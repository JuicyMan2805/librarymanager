package com.example.librarymanager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Author")
public class AuthorEntity extends SuperEntity {

    @Column(name = "Author_Name")
    private String AuthorName;

    @Column(name = "Date_born")
    private LocalDate AuthorBirthday;

}
