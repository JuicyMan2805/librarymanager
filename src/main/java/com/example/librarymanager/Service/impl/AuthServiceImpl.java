package com.example.librarymanager.Service.impl;

import com.example.librarymanager.Customenum.RoleEnum;
import com.example.librarymanager.Customenum.UserTypeEnum;
import com.example.librarymanager.Dto.auth.Input.LoginInput;
import com.example.librarymanager.Dto.auth.Input.SignUpInput;
import com.example.librarymanager.Dto.auth.Output.LoginOutput;
import com.example.librarymanager.Dto.auth.Output.SignUpOutput;
import com.example.librarymanager.Dto.auth.UserAuthentication;
import com.example.librarymanager.Entity.UserEntity;
import com.example.librarymanager.Exception.BusinessException;
import com.example.librarymanager.Mapper.UserMapper;
import com.example.librarymanager.Repository.UserRepository;
import com.example.librarymanager.Service.AuthService;
import com.example.librarymanager.Util.AuthUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * nơi tương tác với cơ sở dữ liệu
 * tương tác vơi SQL
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapper objectMapper;
    //    @Value("${app.secret-key}")
    @Value("${app.secret-key}")
    private String secretKey;


    @Override
    public LoginOutput login(LoginInput input) {
        // Kiểm tra username có tồn tại chưa
        String username = input.getUsername();
        UserEntity existedUser = userRepository.findFirstByUsername(username);
        if (existedUser == null) {
            throw new BusinessException("NOT_EXISTED_USERNAME", "Tài khoản chưa tồn tại!");
        }
        String hashedPassword = AuthUtil.hashPassword(input.getPassword());
        String savedPassword = existedUser.getPassword();
        if (!hashedPassword.equals(savedPassword)) {
            throw new BusinessException("INCORRECT_PASSWORD", "Mật khẩu nhập không chính xác!");
        }
        // Generate jwt(json web token) and return
        UserAuthentication userAuthentication = new UserAuthentication();
        userAuthentication.setUserId(existedUser.getId());
        userAuthentication.setRole(existedUser.getRole());
        userAuthentication.setType(existedUser.getType());
        Map<String, Object> payload = objectMapper.convertValue(userAuthentication,
                new TypeReference<Map<String, Object>>() {
                });
        LoginOutput output = new LoginOutput();
        output.setUserId(existedUser.getId());
        output.setToken(AuthUtil.generateToken(payload, secretKey));
        return output;
    }

    @Override
    public SignUpOutput signUp(SignUpInput input) {
        // Kiểm tra username có tồn tại chưa
        String username = input.getUsername();
        UserEntity existedUsername = userRepository.findFirstByUsername(username);
        if (existedUsername != null) {
            throw new BusinessException("EXISTED_USERNAME", "Tài khoản đã tồn tại!");//quăng lỗi
        }
        String cardIdNumber = input.getCardIdNumber();
        UserEntity existedCardIdNumber = userRepository.findFirstByCardIdNumber(cardIdNumber);
        if (existedCardIdNumber != null) {
            throw new BusinessException("EXISTED_CARD_ID_NUMBER", "Giấy tờ tùy thân đã tồn tại!");
        }
        String phoneNumber = input.getPhoneNumber();        //nhập input
        UserEntity existedPhoneNumber = userRepository.findFirstByPhoneNumber(phoneNumber);     //nhận value từ entity
        if (existedPhoneNumber != null) {   // điều kiện xét
            throw new BusinessException("EXISTED_PHONE_NUMBER", "Số điện thoại đã tồn tại!");
        }
        UserEntity newUser = UserMapper.INSTANCE.mapFromSignUpInput(input);     //lấy thông từ SignUp
        newUser.setRole(RoleEnum.USER);
        newUser.setType(UserTypeEnum.BASIC);
        userRepository.save(newUser);

        SignUpOutput output = new SignUpOutput();
        output.setUserId(newUser.getId());
        return output;
    }
}