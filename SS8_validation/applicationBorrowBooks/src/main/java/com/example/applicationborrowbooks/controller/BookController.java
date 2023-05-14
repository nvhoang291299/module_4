package com.example.applicationborrowbooks.controller;

import com.example.applicationborrowbooks.exception.ExceptionBackBook;
import com.example.applicationborrowbooks.exception.ExceptionOrderBook;
import com.example.applicationborrowbooks.model.Book;
import com.example.applicationborrowbooks.model.Order;
import com.example.applicationborrowbooks.service.IBookService;
import com.example.applicationborrowbooks.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/borrow")
    public String borrow(@RequestParam(value = "id") long id, Model model) throws ExceptionOrderBook{
        Book book = bookService.findById(id).get();
        if (book.getCount() == 0) {
            throw new ExceptionOrderBook();
        }
        if ( bookService.findById(id).isPresent()){
            model.addAttribute("book", book);
        }
        return "borrow";
    }
    @ExceptionHandler(ExceptionOrderBook.class)
    public String catchException() {
        return "errorOrderBook";
    }
    @PostMapping("/borrowBook")
    public String borrowBook(@ModelAttribute(name = "book") Book book, Model model){
        bookService.borrow(book);
        return"redirect:/home";
    }

    @GetMapping("/give_book_back")
    public String backBook(){
        return "backBook";
    }
    @GetMapping("/giveBook")
    public String giveBackBook(@RequestParam(value = "code") long code) throws ExceptionBackBook {
        if (orderService.checkCode(code)){
            return "redirect:/home";
        }
        throw new ExceptionBackBook();
    }
    @ExceptionHandler(ExceptionBackBook.class)
    public String catchExceptionBackBook() {
        return ("errorBackBook");
    }
}
