package com.example.librarymanager.Dto.Book.output;

import com.example.librarymanager.Dto.Book.BookInfoDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BorrowHistoryOutput {
    private Long id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private BookInfoDTO bookInfo;
}
