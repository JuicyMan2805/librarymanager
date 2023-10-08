package com.example.librarymanager.Service.impl;

import com.example.librarymanager.Dto.Account.output.GetPersonalInfoOutput;
import com.example.librarymanager.Dto.auth.UserAuthentication;
import com.example.librarymanager.Entity.UserEntity;
import com.example.librarymanager.Exception.BusinessException;
import com.example.librarymanager.Mapper.UserMapper;
import com.example.librarymanager.Repository.UserRepository;
import com.example.librarymanager.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public GetPersonalInfoOutput getPersonalInfo() {
        UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userFound = userRepository.findById(userAuthentication.getUserId())
                .orElseThrow(() -> new BusinessException("USER_NOT_FOUND", "Thông tin cá nhân không được tìm thấy"));//orElseThrow: nếu không tìm thấy
        return UserMapper.INSTANCE.mapToPersonalInfoOutput(userFound);
    }
}
