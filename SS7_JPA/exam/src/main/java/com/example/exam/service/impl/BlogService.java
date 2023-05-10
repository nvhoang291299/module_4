package com.example.exam.service.impl;

import com.example.exam.model.Blog;
import com.example.exam.repository.IBlogRepository;
import com.example.exam.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll(Sort sort) {
        return blogRepository.findAll(sort);
    }

    @Override
    public Optional<Blog> findById(long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(long idDel) {
        blogRepository.deleteById(idDel);
    }

//    @Override
//    public List<Blog> findByNameBlogContaining(String name) {
//        return  blogRepository.findByNameBlogContaining(name);
//    }
}
