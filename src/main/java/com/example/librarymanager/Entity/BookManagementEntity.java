package com.example.librarymanager.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * lưu thông tin mượn trả sách, id sách và id user mượn
 */


@Getter
@Setter
@Builder    //builder cần 2 cái dưới
@AllArgsConstructor // tuwj taoj constructor
@NoArgsConstructor
@Entity
@Table(name = "book_management")
public class BookManagementEntity extends SuperEntity {
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bookDistribution_id")
    private BookDistributionEntity bookDistribution;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "borrow_date")
    private LocalDate borrowDate;

    @Column(name = "return_date")
    private LocalDate returndate;

}
