package com.example.librarymanager.Dto.Account.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordInput {
    private String oldpassword;
    private String newpassword;
}
