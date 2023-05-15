package com.example.applicationborrowbooks.service.impl;

import com.example.applicationborrowbooks.model.Book;
import com.example.applicationborrowbooks.model.Order;
import com.example.applicationborrowbooks.repository.IBookRepository;
import com.example.applicationborrowbooks.repository.IOrderRepository;
import com.example.applicationborrowbooks.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void borrow(Book book) {
        book.setCount(book.getCount()-1);
        bookRepository.save(book);
    }

    @Override
    public void pay(Book book) {
        book.setCount(book.getCount()+1);
        bookRepository.save(book);
    }

}
