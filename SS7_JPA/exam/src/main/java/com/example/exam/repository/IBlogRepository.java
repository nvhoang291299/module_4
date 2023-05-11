package com.example.exam.repository;

import com.example.exam.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Override
    <S extends Blog> S save(S blog);

    @Override
    Optional<Blog> findById(Long id);

    @Override
    void deleteById(Long aLong);

    @Override
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findByNameBlogContaining(String name);

}
