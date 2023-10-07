package com.example.librarymanager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class SuperEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "create_time")
    private LocalDateTime createTime;
    @Column(name = "update_Time")
    private LocalDateTime updateTime;

    @PrePersist // tự lưu date time
    public void preCreate() {
        createTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateTime = LocalDateTime.now();
    }
}
