package com.example.librarymanager.Repository;

import com.example.librarymanager.Entity.BookDistributionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookDistributionRepository extends JpaRepository<BookDistributionEntity, Long> {
    List<BookDistributionEntity> findByBookIdAndStatus(Long bookID, String status);

    Optional<BookDistributionEntity> findFirstByBookIdAndStatus(Long bookID, String status);
}