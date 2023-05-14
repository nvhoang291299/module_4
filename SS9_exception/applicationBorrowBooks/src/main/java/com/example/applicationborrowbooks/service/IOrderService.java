package com.example.applicationborrowbooks.service;

import com.example.applicationborrowbooks.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IOrderService {
    void save(Order order);
    Optional<Order> findById(long id);

    boolean checkCode(long code);
}
