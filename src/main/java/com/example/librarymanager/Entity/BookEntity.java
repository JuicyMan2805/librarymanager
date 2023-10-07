package com.example.librarymanager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Book")
public class BookEntity extends SuperEntity {

    @Column(name = "BookName")
    private String name;

    @Column(name = "Comment")
    private String shortDescription;

    @Column(name = "Date_of_publication")
    private LocalDate provideDate;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

}
