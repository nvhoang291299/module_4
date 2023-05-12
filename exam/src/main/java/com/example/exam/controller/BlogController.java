package com.example.exam.controller;

import com.example.exam.model.Blog;
import com.example.exam.service.IBlogService;
import com.example.exam.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public String getAll(Model model){
        model.addAttribute("blogList", blogService.findAll());
        return "blog/blog";
    }
    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
        return "blog/create";
    }

    @GetMapping("/view")
    public String view(@RequestParam(value = "id") long id, Model model){
        ;
        model.addAttribute("blog", blogService.findById(id).get());
        return "blog/view";
    }
    @GetMapping("/delete")
    public String deleteBlog(@RequestParam(value = "id") long idDel, Model model ){
        blogService.delete(idDel);
        return "redirect:/blog";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id") int id, Model model){
        if (blogService.findById(id).isPresent()) {
            model.addAttribute("categories", categoryService.findAll());
            model.addAttribute("blog", blogService.findById(id).get());
        }
        return "blog/update";
    }

    @GetMapping("/search{name}")
    public String search(@PathVariable String name, Model model){
        model.addAttribute("blogList", blogService.findByNameBlogContaining(name));
        return "redirect:/blog";
    }
    @GetMapping("blog/{postDate}")
    public String sortByDate(@PathVariable String postDate, Model model){
        model.addAttribute("blogList", blogService.findByBlogWithSorting(postDate));
        return "redirect:/blog";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("blog") Blog blog){
        blogService.save(blog);
        return "redirect:/blog";
    }
}
