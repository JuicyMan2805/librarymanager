package com.example.librarymanager.Dto.auth.Output;

import lombok.Getter;
import lombok.Setter;

/**
 * chứa user ID và password dạng token
 */
@Getter
@Setter
public class SignUpOutput {
    private Long userId;
    private String token;
}