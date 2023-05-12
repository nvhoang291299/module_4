package com.example.applicationborrowbooks.service;

import com.example.applicationborrowbooks.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Optional<Book> findById(long id);
}
