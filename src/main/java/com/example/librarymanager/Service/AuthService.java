package com.example.librarymanager.Service;

import com.example.librarymanager.Dto.auth.Input.LoginInput;
import com.example.librarymanager.Dto.auth.Input.SignUpInput;
import com.example.librarymanager.Dto.auth.Output.SignUpOutput;

/**
 * @author mangvientrieu
 */
public interface AuthService {
//    SignUpOutput login(SignUpInput input);

    SignUpOutput login(LoginInput input);

    SignUpOutput signUp(SignUpInput input);

}