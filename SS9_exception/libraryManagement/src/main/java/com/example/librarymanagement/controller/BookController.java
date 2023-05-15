package com.example.librarymanagement.controller;

import com.example.librarymanagement.exception.ExceptionBackBook;
import com.example.librarymanagement.exception.ExceptionOrderBook;
import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.IBookService;
import com.example.librarymanagement.service.IOrderService;
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
        model.addAttribute("order", orderService.getCode());
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
    public String backBook(@RequestParam long id, Model model){
        model.addAttribute("book", bookService.findById(id));
        return "pay";
    }
    @GetMapping("/payBook")
    public String payBook(@RequestParam(name = "code") long code) throws ExceptionBackBook {
        Book book = null;
        try{
            book = orderService.getBook(code);
            bookService.pay(book);
        }
        catch (Exception e){
            throw new ExceptionBackBook();
        }
            return "redirect:/home";
    }
}
