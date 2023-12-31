package com.example.librarymanager.Mapper;

import com.example.librarymanager.Dto.Account.output.GetPersonalInfoOutput;
import com.example.librarymanager.Dto.auth.Input.SignUpInput;
import com.example.librarymanager.Entity.UserEntity;
import com.example.librarymanager.Util.AuthUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author mangvientrieu
 */
@Mapper(imports = AuthUtil.class)       //import thủ công class AuthUlit
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //chỉ định Password
    @Mapping(target = "password", expression = "java(AuthUtil.hashPassword(input.getPassword()))")

    UserEntity mapFromSignUpInput(SignUpInput input);

    GetPersonalInfoOutput mapToPersonalInfoOutput(UserEntity input);

}