package com.example.exam.repository;

import com.example.exam.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Override
    List<Blog> findAll();

    @Override
    <S extends Blog> S save(S blog);
}
