package com.example.exam.repository;

import com.example.exam.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    void delete(int idDel);
}
