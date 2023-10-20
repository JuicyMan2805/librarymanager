package com.example.librarymanager.Service;

import java.util.List;

public interface CRUDservice<T> {
    T create(T input);

    List<T> read();

    T update(T newValue);

    boolean delete(Long id);
}

