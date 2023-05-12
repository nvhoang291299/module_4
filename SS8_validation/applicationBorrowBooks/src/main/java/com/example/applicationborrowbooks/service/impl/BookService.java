package com.example.applicationborrowbooks.service.impl;

import com.example.applicationborrowbooks.model.Book;
import com.example.applicationborrowbooks.repository.IBookRepository;
import com.example.applicationborrowbooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

}
