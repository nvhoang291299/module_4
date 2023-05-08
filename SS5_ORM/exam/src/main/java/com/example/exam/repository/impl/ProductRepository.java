package com.example.exam.repository.impl;

import com.example.exam.model.Product;
import com.example.exam.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            return session.createQuery("from Product", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void delete(int idDel) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product product = session.get(Product.class, idDel);
            if (product != null){
                session.delete(product);
            }
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {

        return null;
    }

    @Override
    public void update(int product) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            Product product = session.get(Product.class, idDel);
            if (product != null){
                session.delete(product);
            }
            transaction.commit();
        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        return products;
    }
}
