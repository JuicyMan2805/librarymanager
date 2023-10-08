package com.example.librarymanager.Dto.auth.Output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginOutput {
    private Long userId;
    private String token;
}
