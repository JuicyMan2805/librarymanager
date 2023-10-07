package com.example.librarymanager.Entity;

import com.example.librarymanager.Customenum.RoleEnum;
import com.example.librarymanager.Customenum.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Library_user")
public class UserEntity extends SuperEntity {
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserTypeEnum type;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "card_id_number", unique = true)
    private String cardIdNumber;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

}
