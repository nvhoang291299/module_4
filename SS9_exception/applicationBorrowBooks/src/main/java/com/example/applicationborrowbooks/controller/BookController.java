package com.example.applicationborrowbooks.controller;

import com.example.applicationborrowbooks.exception.ExceptionOrderBook;
import com.example.applicationborrowbooks.model.Book;
import com.example.applicationborrowbooks.service.IBookService;
import com.example.applicationborrowbooks.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IOrderService orderService;
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("books", bookService.findAll());
        return "home";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }
    @GetMapping("/borrowBook")
    public String borrow(@RequestParam(value = "id") long id) throws ExceptionOrderBook{
        Book book = bookService.findById(id);
        if (book.getCount() == 0) {
            throw new ExceptionOrderBook();
        } else {
            bookService.borrow(book);
        }
        return "redirect:/home";
    }
    @ExceptionHandler(ExceptionOrderBook.class)
    public String catchException() {
        return "errorOrderBook.html";
    }
    @GetMapping("/pay")
    public String payBook(@RequestParam long id){
        Book book = bookService.findById(id);
        bookService.pay(book);
        return "redirect:/home";
    }
}
