package com.example.librarymanager.Dto.auth.Input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * @author mangvientrieu
 */
@Getter
@Setter
public class SignUpInput {
    private String username;
    private String password;
    private String name;
    private LocalDate birthday;
    private String cardIdNumber;
    private String phoneNumber;
}