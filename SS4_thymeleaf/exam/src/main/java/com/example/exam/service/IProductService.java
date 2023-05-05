package com.example.exam.service;

import com.example.exam.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void delete(int idDel);
}
