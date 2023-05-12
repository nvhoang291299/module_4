package com.example.exam.repository;

import com.example.exam.model.Blog;
import com.example.exam.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Override
    List<Category> findAll();

    <S extends Category> S save(S category);

    @Override
    Optional<Category> findById(Long id);

    @Override
    void deleteById(Long aLong);

}
