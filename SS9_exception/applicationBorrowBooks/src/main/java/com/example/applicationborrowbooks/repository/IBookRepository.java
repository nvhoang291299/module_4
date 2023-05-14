package com.example.applicationborrowbooks.repository;

import com.example.applicationborrowbooks.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
