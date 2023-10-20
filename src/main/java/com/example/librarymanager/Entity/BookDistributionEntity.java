package com.example.librarymanager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book_distribution")
public class BookDistributionEntity extends SuperEntity {
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "bookDistribution", fetch = FetchType.LAZY)
    private List<BookManagementEntity> histories;
}
