package com.example.librarymanager.Service.impl;

import com.example.librarymanager.Dto.Book.input.BorrowBookInput;
import com.example.librarymanager.Dto.Book.input.ReturnBookInput;
import com.example.librarymanager.Entity.BookDistributionEntity;
import com.example.librarymanager.Entity.BookEntity;
import com.example.librarymanager.Entity.BookManagementEntity;
import com.example.librarymanager.Entity.UserEntity;
import com.example.librarymanager.Exception.BusinessException;
import com.example.librarymanager.Repository.BookDistributionRepository;
import com.example.librarymanager.Repository.BookManagementRepository;
import com.example.librarymanager.Repository.BookRepository;
import com.example.librarymanager.Repository.UserRepository;
import com.example.librarymanager.Repository.projection.BorrowHistoryProjection;
import com.example.librarymanager.Service.BookService;
import com.example.librarymanager.Util.AuthUtil;
import org.apache.cxf.common.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    public static final String ENABLE = "ENABLE";
    public static final String BORROW = "BORROW";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookDistributionRepository bookDistributionRepository;
    @Autowired
    private BookManagementRepository bookManagementRepository;
    @Autowired
    private BookRepository bookRepository;


    @Override
    @Transactional
    public Long borrowBook(BorrowBookInput input) {
        Long bookId = input.getBookId();
        Long userId = AuthUtil.getUserId(); //lấy thooing tin user
        UserEntity user = userRepository.findById(userId).orElseThrow(
                () -> new BusinessException("USER_NOT_FOUND", "Thông tin cá nhân không được tìm thấy"));
        BookDistributionEntity distributionEntity = bookDistributionRepository.findFirstByBookIdAndStatus(bookId,
                ENABLE).orElseThrow(() -> new BusinessException("BOOK_UNAVAILABLE", "Thư viện đã hết sách mà bạn tìm"));
        distributionEntity.setStatus(BORROW);
        BookManagementEntity bookManagement = BookManagementEntity
                .builder()
                .user(user)
                .bookDistribution(distributionEntity)
                .borrowDate(LocalDate.now())
                .returndate(null)
                .build();
        BookManagementEntity saved = bookManagementRepository.save(bookManagement);
        return saved.getId();
    }

    @Override
    public Boolean returnBook(ReturnBookInput input) {
        Long userId = AuthUtil.getUserId();
        List<BookManagementEntity> bookManagements = bookManagementRepository.findBorrowInformation(userId,
                input.getBookDistributionId());
        if (CollectionUtils.isEmpty(bookManagements)) {
            throw new BusinessException("INFORMATION_NOT_FOUND", "Thông tin mượn sách không được tìm thấy");
        } else if (bookManagements.size() > 1) {
            throw new BusinessException("INFORMATION_INCORRECT",
                    "Thông tin mượn sách không hợp lệ. Vui lòng kiểm tra lại");
        } else {
            BookManagementEntity bookManagement = bookManagements.get(0);
            bookManagement.setReturndate(LocalDate.now());
            bookManagement.getBookDistribution().setStatus(ENABLE);
            bookManagementRepository.save(bookManagement);
        }
        return true;
    }

    @Override
    public Page<BorrowHistoryProjection> getBorrowHistory(int page, int size) {
        Long userId = AuthUtil.getUserId();
        return bookManagementRepository.findBorrowHistory(userId,
                PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate")));
    }

    @Override
    public List<BookEntity> searchBookByKeyword(String keyword) {
        return bookRepository.searchBookByKeyword(keyword);
    }

    @Override
    public List<BookEntity> importBookFromExcel(MultipartFile file) {
        return null;
    }

    @Override
    public BookEntity create(BookEntity input) {
        return null;
    }

    @Override
    public List<BookEntity> read() {
        return null;
    }

    @Override
    public BookEntity update(BookEntity newValue) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
