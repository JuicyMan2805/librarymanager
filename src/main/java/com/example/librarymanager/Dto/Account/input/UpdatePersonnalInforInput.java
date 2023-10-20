package com.example.librarymanager.Dto.Account.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdatePersonnalInforInput {
    private String password;
    private String name;
    private LocalDate birthday;
    private String cardIdNumber;
    private String phoneNumber;
}
