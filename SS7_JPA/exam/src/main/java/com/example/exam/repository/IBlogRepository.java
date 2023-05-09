package com.example.exam.repository;

import com.example.exam.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Override
    List<Blog> findAll();

    @Override
    <S extends Blog> S save(S blog);

    @Override
    Optional<Blog> findById(Long id);

    @Override
    void deleteById(Long aLong);
}
