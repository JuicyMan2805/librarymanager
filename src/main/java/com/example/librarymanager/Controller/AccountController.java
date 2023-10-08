package com.example.librarymanager.Controller;

import com.example.librarymanager.Dto.Account.output.GetPersonalInfoOutput;
import com.example.librarymanager.Dto.api.ReposnseDto;
import com.example.librarymanager.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mangvientrieu
 * Controller dùng để trung cập và chỉnh sửa thông tin cá nhân
 */

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/personal-info")
    public ReposnseDto<GetPersonalInfoOutput> getPersonalInfo() {
        return ReposnseDto.ok(accountService.getPersonalInfo());
    }

}
