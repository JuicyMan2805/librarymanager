package com.example.librarymanager.Service.impl;

import com.example.librarymanager.Dto.Account.input.ChangePasswordInput;
import com.example.librarymanager.Dto.Account.input.UpdatePersonnalInforInput;
import com.example.librarymanager.Dto.Account.output.GetPersonalInfoOutput;
import com.example.librarymanager.Entity.UserEntity;
import com.example.librarymanager.Exception.BusinessException;
import com.example.librarymanager.Mapper.UserMapper;
import com.example.librarymanager.Repository.UserRepository;
import com.example.librarymanager.Service.AccountService;
import com.example.librarymanager.Util.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public GetPersonalInfoOutput getPersonalInfo() {
        UserEntity userFound = userRepository.findById(AuthUtil.getUserId())
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "Thông tin cá nhân không được tìm thấy"));//orElseThrow: nếu không tìm thấy
        return UserMapper.INSTANCE.mapToPersonalInfoOutput(userFound);
    }


    @Override
    public GetPersonalInfoOutput updatePersonalInfo(UpdatePersonnalInforInput input) {
        UserEntity userFound = userRepository.findById(AuthUtil.getUserId())    //nhận userId
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "Thông tin cá nhân không được tìm thấy"));//orElseThrow: nếu không tìm thấy
        if (input.getName() == null) {
            userFound.setName(input.getName());
        }
        Optional.ofNullable(input.getName()).ifPresent(userFound::setName);   //Optional: có thể chia trường hợp null hoặc ko null
        Optional.ofNullable(input.getBirthday()).ifPresent(userFound::setBirthday);    //nếu ko null -> truyền input = birthday
        Optional.ofNullable(input.getCardIdNumber()).ifPresent(userFound::setCardIdNumber);
        Optional.ofNullable(input.getPhoneNumber()).ifPresent(userFound::setPhoneNumber);
        return UserMapper.INSTANCE.mapToPersonalInfoOutput(userRepository.save(userFound));     //lưu lại
    }


    @Override
    public Boolean changePassword(ChangePasswordInput input) {
        UserEntity userFound = userRepository.findById(AuthUtil.getUserId())
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "Thông tin cá nhân không được tìm thấy"));
        String hashedOldPassword = AuthUtil.hashPassword(input.getOldpassword());
        String existedPassword = userFound.getPassword();
        if (!hashedOldPassword.equals(existedPassword)) {
            throw new BusinessException("INCORRECT_PASSWORD", "Mật khẩu nhập không chính xác!");
        }
        String hashedNewPassword = AuthUtil.hashPassword(input.getNewpassword());
        if (hashedNewPassword.equals(existedPassword)) {
            throw new BusinessException("NEW_PASSWORD_MUST_DIFFERENT_OLD_PASSWORD",
                    "Mật khẩu mới phải khác mật khẩu cũ!");
        }
        userFound.setPassword(hashedNewPassword);
        userRepository.save(userFound);

        return true;
    }
}
