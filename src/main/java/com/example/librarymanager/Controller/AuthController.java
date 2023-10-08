package com.example.librarymanager.Controller;

import com.example.librarymanager.Dto.api.ReposnseDto;
import com.example.librarymanager.Dto.auth.Input.LoginInput;
import com.example.librarymanager.Dto.auth.Input.SignUpInput;
import com.example.librarymanager.Dto.auth.Output.LoginOutput;
import com.example.librarymanager.Dto.auth.Output.SignUpOutput;
import com.example.librarymanager.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mangvientrieu
 * Controller dùng để quản lý việc đăng nhập, đăng kí, các api liên quan đến authen/author
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ReposnseDto<LoginOutput> login(@RequestBody LoginInput input) { //requestBody dùng để nhận body
        return ReposnseDto.ok(authService.login(input));
    }

    @PostMapping("/sign-up")
    public ReposnseDto<SignUpOutput> signUp(@RequestBody SignUpInput input) {
        return ReposnseDto.ok(authService.signUp(input));
    }

}