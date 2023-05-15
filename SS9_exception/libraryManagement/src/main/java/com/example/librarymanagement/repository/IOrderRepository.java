package com.example.librarymanagement.repository;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select b.* from orders o join books b on o.code = b.code where o.code = :code;", nativeQuery = true)
    Book getBook(long code);
}
