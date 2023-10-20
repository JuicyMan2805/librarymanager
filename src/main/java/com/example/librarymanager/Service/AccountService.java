package com.example.librarymanager.Service;

import com.example.librarymanager.Dto.Account.input.ChangePasswordInput;
import com.example.librarymanager.Dto.Account.input.UpdatePersonnalInforInput;
import com.example.librarymanager.Dto.Account.output.GetPersonalInfoOutput;

public interface AccountService {
    GetPersonalInfoOutput getPersonalInfo();

    GetPersonalInfoOutput updatePersonalInfo(UpdatePersonnalInforInput input);


    Boolean changePassword(ChangePasswordInput input);
}
