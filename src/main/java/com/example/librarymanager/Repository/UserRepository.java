package com.example.librarymanager.Repository;

import com.example.librarymanager.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
/nơi tương tác với cơ sở dữ liệu
tương tác vơi SQL
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findFirstByUsername(String username);

    UserEntity findFirstByCardIdNumber(String cardIdNumber);

    UserEntity findFirstByPhoneNumber(String phoneNumber);
}