package com.example.applicationborrowbooks.repository;

import com.example.applicationborrowbooks.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
