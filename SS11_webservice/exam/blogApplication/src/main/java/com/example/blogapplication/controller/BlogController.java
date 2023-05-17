package com.example.blogapplication.controller;

import com.example.blogapplication.model.Blog;
import com.example.blogapplication.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> getAll(){
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/view")
    public ResponseEntity<Blog> view(@RequestParam(value = "id") long id){
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchByCategory(@RequestParam(value = "category") String category){
        List<Blog> listSearch = blogService.findByCategory(category);
        if (listSearch.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listSearch, HttpStatus.OK);
    }

//    @PostMapping("/create")
//    public ResponseEntity<Blog> create(@RequestBody Blog blog){
//        Blog blog1 = blogService.save(blog);
//        return new ResponseEntity<>(blog1, HttpStatus.OK);
//    }
//
//    @PatchMapping("/edit")
//    public ResponseEntity<Blog> edit(@RequestParam(value = "id") long id, @RequestParam(value = "content") String content){
//        Blog blog1 = blogService.findById(id);
//        blog1.setContent(content);
//        return new ResponseEntity<>(blogService.save(blog1), HttpStatus.OK);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<Blog> update(@RequestParam(value = "id") long id, @RequestBody Blog blog){
//        Blog blog1 = blogService.findById(id);
//        blog1.setNameBlog(blog.getNameBlog());
//        blog1.setContent(blog.getContent());
//        blog1.setWriter(blog.getWriter());
//        blog1.setPostDate(blog.getPostDate());
//        blog1.getCategory().setNameCategory(blog.getCategory().getNameCategory());
//        return new ResponseEntity<>(blogService.save(blog1), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<Blog> delete(@RequestParam(value = "id") long id){
//        blogService.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
