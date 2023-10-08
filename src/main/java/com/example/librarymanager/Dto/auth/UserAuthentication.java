package com.example.librarymanager.Dto.auth;

import com.example.librarymanager.Customenum.RoleEnum;
import com.example.librarymanager.Customenum.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthentication {
    private Long userId;
    private RoleEnum role;
    private UserTypeEnum type;
}
