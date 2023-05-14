package com.example.applicationborrowbooks.service.impl;

import com.example.applicationborrowbooks.model.Order;
import com.example.applicationborrowbooks.repository.IOrderRepository;
import com.example.applicationborrowbooks.service.IOrderService;
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
    public boolean checkCode(long code) {
        List<Order> orderList = orderRepository.findAll();
        for (Order order:orderList) {
            if (order.getCode() == code){
                return true;
            }
        }
        return false;
    }
}
