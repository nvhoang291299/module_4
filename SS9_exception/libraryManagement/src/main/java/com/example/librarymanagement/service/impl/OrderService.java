package com.example.librarymanagement.service.impl;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Order;
import com.example.librarymanagement.repository.IOrderRepository;
import com.example.librarymanagement.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order getCode() {
        Order order = new Order();
        order.setCode((long) (Math.random() * (99999-10000)+10000));
        return order;
    }

    @Override
    public Book getBook(long code) {
        return orderRepository.getBook(code);
    }
}
