package com.example.librarymanager.Dto.Account.output;

import com.example.librarymanager.Customenum.RoleEnum;
import com.example.librarymanager.Customenum.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GetPersonalInfoOutput {
    private String id;
    private String username;
    private String password;
    private String name;
    private UserTypeEnum type;
    private LocalDate birthday;
    private String cardIdNumber;
    private String phoneNumber;
    private RoleEnum role;
}
