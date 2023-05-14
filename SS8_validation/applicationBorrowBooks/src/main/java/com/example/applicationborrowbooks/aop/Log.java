package com.example.applicationborrowbooks.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {
    @AfterThrowing(value = "execution(* com.example.applicationborrowbooks.controller.BookController.borrowBook())")
    public void checkErrors(){
        System.out.println("bạn không thể mượn sách");
    }
    @After(value = "execution(* com.example.applicationborrowbooks.controller.BookController.borrowBook())")
    public void logDone(){
        System.out.println("bạn đã mượn thành công");
    }
}
