package com.example.applicationborrowbooks.aop;

import org.aspectj.lang.annotation.*;
;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {
    @AfterReturning(pointcut = "execution(* com.example.applicationborrowbooks.controller.BookController.borrow())")
    public void logBorrow(){
        System.out.println("đã hết sách");
    }
    @AfterThrowing(pointcut = "execution(* com.example.applicationborrowbooks.controller.BookController.borrow())")
    public void logPay(){
        System.out.println("sách được thay đổi");
    }

    @Around(pointcut = "execution(* com.example.applicationborrowbooks.controller.BookController.*Book())")
    public void logState(){
        System.out.println("Có thay đổi");
    }
}
