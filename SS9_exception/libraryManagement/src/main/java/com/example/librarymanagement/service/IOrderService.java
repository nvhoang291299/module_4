package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IOrderService {
    void save(Order order);
    Optional<Order> findById(long id);

//    boolean checkCode(long code);

    Order getCode();

    Book getBook(long code);
}
