package com.example.librarymanager.Controller;

import com.example.librarymanager.Dto.Account.input.ChangePasswordInput;
import com.example.librarymanager.Dto.Account.input.UpdatePersonnalInforInput;
import com.example.librarymanager.Dto.Account.output.GetPersonalInfoOutput;
import com.example.librarymanager.Dto.api.ReposnseDto;
import com.example.librarymanager.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update-info")
    public ReposnseDto<GetPersonalInfoOutput> updatePersonalInfo(@RequestBody UpdatePersonnalInforInput input) {
        return ReposnseDto.ok(accountService.updatePersonalInfo(input));
    }

    @PostMapping("/change-password")
    public ReposnseDto<Boolean> changePassword(@RequestBody ChangePasswordInput input) {
        return ReposnseDto.ok(accountService.changePassword(input));
    }

}
