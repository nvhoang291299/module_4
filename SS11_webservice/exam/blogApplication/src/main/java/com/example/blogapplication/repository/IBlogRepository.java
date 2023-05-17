package com.example.blogapplication.repository;

import com.example.blogapplication.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "select b.* from blogs b join categorys c on b.id_category = c.id where name_category = ?1", nativeQuery = true)
    List<Blog> findBlogsByCategory(String category);
}
