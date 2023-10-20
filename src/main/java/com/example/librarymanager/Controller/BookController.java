package com.example.librarymanager.Controller;

import com.example.librarymanager.Dto.Book.input.BorrowBookInput;
import com.example.librarymanager.Dto.Book.input.ReturnBookInput;
import com.example.librarymanager.Dto.api.ReposnseDto;
import com.example.librarymanager.Entity.BookEntity;
import com.example.librarymanager.Repository.projection.BorrowHistoryProjection;
import com.example.librarymanager.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/borrow-book")
    public ReposnseDto<Long> borrowBook(@RequestBody BorrowBookInput input) {
        return ReposnseDto.ok(bookService.borrowBook(input));
    }

    @PostMapping("/return-book")
    public ReposnseDto<Boolean> returnBook(@RequestBody ReturnBookInput input) {
        return ReposnseDto.ok(bookService.returnBook(input));
    }

    @GetMapping("/borrow-history")
    public ReposnseDto<Page<BorrowHistoryProjection>> getBorrowHistory(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "30") int size) {
        return ReposnseDto.ok(bookService.getBorrowHistory(page, size));
    }

    @GetMapping("/search")
    public ReposnseDto<List<BookEntity>> getBorrowHistory(@RequestParam(defaultValue = "") String keyword) {
        return ReposnseDto.ok(bookService.searchBookByKeyword(keyword));
    }
}
