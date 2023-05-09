package com.example.exam.repository.impl;

import com.example.exam.model.Product;
import com.example.exam.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "pen", 5000, "black", "deli"));
        productList.add(new Product(2, "notebook", 10000, "80 paper", "campus"));
        productList.add(new Product(3, "pen", 5000, "blue", "deli"));
        productList.add(new Product(4, "pencil", 3000, "limited", "thienlong"));
        productList.add(new Product(5, "ruler", 7000, "20cm", "thienlong"));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        Product product1 = new Product();
        product1.setId(productList.size()+1);
        product1.setNameProduct(product.getNameProduct());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setProducer(product.getProducer());
        productList.add(product1);
    }

    @Override
    public void delete(int idDel) {
        for (Product element: productList) {
            if (element.getId() == idDel){
                productList.remove(element);
                return;
            }
        }
    }

    @Override
    public Product findById(int id) {
        for (Product element: productList) {
            if (element.getId() == id){
                productList.remove(element);
                return element;
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (Product element: productList) {
            if (element.getId() == product.getId()){
                element.setNameProduct(product.getNameProduct());
                element.setPrice((product.getPrice()));
                element.setDescription(product.getDescription());
                element.setProducer(product.getProducer());
                return;
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product element : productList) {
            if (element.getNameProduct().contains(name)) {
                products.add(element);
            }
        }
        return products;
    }
}
