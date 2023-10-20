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

//    @ManyToOne()
//    @JoinColumn(name = "Total")
//    private CategoryEntity total;
//
//    @ManyToOne()
//    @JoinColumn(name = "Existed")
//    private AuthorEntity existed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Category_id")
    private CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Author_id")
    private AuthorEntity author;

}
