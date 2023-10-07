//package com.example.librarymanager.Exception;
//
//import com.example.librarymanager.Customenum.RoleEnum;
//import com.example.librarymanager.Customenum.UserTypeEnum;
//import com.example.librarymanager.Dto.auth.Input.LoginInput;
//import com.example.librarymanager.Dto.auth.Input.SignUpInput;
//import com.example.librarymanager.Dto.auth.Output.SignUpOutput;
//import com.example.librarymanager.Entity.UserEntity;
//import com.example.librarymanager.Exception.BusinessException;
//import com.example.librarymanager.Mapper.UserMapper;
//import com.example.librarymanager.Repository.UserRepository;
//import com.example.librarymanager.Service.AuthService;
//import com.example.librarymanager.Util.AuthUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author mangvientrieu
// */
//@Service
//public class Errorhandle implements AuthService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public LoginInput login(LoginInput input) {
//        // Kiểm tra username có tồn tại chưa
//        String username = input.getUsername();
//        UserEntity existedUsername = userRepository.findFirstByUsername(username);
//        if (existedUsername == null) {
//            throw new BusinessException("NOT_EXISTED_USERNAME", "Tài khoản chưa tồn tại!");
//        }
//        String hashedpassword = AuthUtil.hashPassword(input.getPassword());
//        String savedPassword = existedUsername.getPassword();
//            if (!hashedpassword.equals(savedPassword)){
//                throw new BusinessException("INCORRECT_PASSWORD", "Mật khẩu sai");
//            }
//        SignUpOutput output = new SignUpOutput();
//        output.setUserId(existedUsername.getId());
//        return output;
//
//    @Override
//    public SignUpOutput signUp(SignUpInput input) {
//        // Kiểm tra username có tồn tại chưa
//        String username = input.getUsername();
//        UserEntity existedUsername = userRepository.findFirstByUsername(username);
//        if (existedUsername != null) {
//            throw new BusinessException("EXISTED_USERNAME", "Tài khoản đã tồn tại!");
//        }
//        String cardIdNumber = input.getCardIdNumber();
//        UserEntity existedCardIdNumber = userRepository.findFirstByCardIdNumber(cardIdNumber);
//        if (existedCardIdNumber != null) {
//            throw new BusinessException("EXISTED_CARD_ID_NUMBER", "Giấy tờ tùy thân đã tồn tại!");
//        }
//        String phoneNumber = input.getPhoneNumber();
//        UserEntity existedPhoneNumber = userRepository.findFirstByPhoneNumber(phoneNumber);
//        if (existedPhoneNumber != null) {
//            throw new BusinessException("EXISTED_PHONE_NUMBER", "Số điện thoại đã tồn tại!");
//        }
//        UserEntity newUser = UserMapper.INSTANCE.mapFromSignUpInput(input);
//        newUser.setRole(RoleEnum.USER);
//        newUser.setType(UserTypeEnum.BASIC);
//        userRepository.save(newUser);
//
//        SignUpOutput output = new SignUpOutput();
//        output.setUserId(newUser.getId());
//        return output;
//    }
//}