package com.example.librarymanager.Dto.auth.Output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * chứa user ID và password dạng token
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpOutput {
    private Long userId;
    private String token;
}