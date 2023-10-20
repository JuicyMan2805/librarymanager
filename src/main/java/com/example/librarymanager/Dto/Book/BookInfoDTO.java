package com.example.librarymanager.Dto.Book;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookInfoDTO {
    private Long bookDistributionId;
    private Long bookId;
    private String name;
    private String shortDescription;
    private LocalDate publishedDate;
    private String authorName;
    private String categoryName;
}
