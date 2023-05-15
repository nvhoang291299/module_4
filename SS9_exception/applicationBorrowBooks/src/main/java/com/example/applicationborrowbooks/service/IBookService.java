package com.example.applicationborrowbooks.service;

import com.example.applicationborrowbooks.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Book findById(long id);

    void save(Book book);

    void borrow(Book book);

    void pay(Book book);
}
