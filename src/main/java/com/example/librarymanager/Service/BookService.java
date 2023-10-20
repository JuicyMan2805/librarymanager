package com.example.librarymanager.Service;

import com.example.librarymanager.Dto.Book.input.BorrowBookInput;
import com.example.librarymanager.Dto.Book.input.ReturnBookInput;
import com.example.librarymanager.Entity.BookEntity;
import com.example.librarymanager.Repository.projection.BorrowHistoryProjection;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService extends CRUDservice<BookEntity> {
    Long borrowBook(BorrowBookInput input);

    Boolean returnBook(ReturnBookInput input);

    Page<BorrowHistoryProjection> getBorrowHistory(int page, int size);

    List<BookEntity> searchBookByKeyword(String keyword);

    List<BookEntity> importBookFromExcel(MultipartFile file);

//    List<CountBookProjection> countTotalBook();
//
//    List<CountBookProjection> countExistedBook();
}
