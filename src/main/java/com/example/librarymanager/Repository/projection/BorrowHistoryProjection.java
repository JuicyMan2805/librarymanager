package com.example.librarymanager.Repository.projection;

import com.example.librarymanager.Entity.BookManagementEntity;

import java.time.LocalDate;

/**
 * Projection for {@link BookManagementEntity}
 */
public interface BorrowHistoryProjection {
    Long getId();

    Long getBookDistributionId();

    LocalDate getCreateDate();

    LocalDate getBorrowDate();

    LocalDate getReturnDate();

    String getBookName();
}