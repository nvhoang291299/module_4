package com.example.librarymanagement.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Log {
    private int count = 0;
    @After("execution(* com.example.librarymanagement.controller.BookController.*())")
    public void methodAfter(JoinPoint joinPoint){
        count++;
        System.err.println(joinPoint.getSignature().getName()+"Số người vào thư viện: "+ count);
    }
    @AfterReturning(pointcut = "execution(* com.example.librarymanagement.controller.BookController.borrow())")
    public void logBorrow(){
        System.out.println("đã hết sách");
    }
    @AfterThrowing(pointcut = "execution(* com.example.librarymanagement.controller.BookController.borrow())")
    public void logPay(){
        System.out.println("sách được thay đổi");
    }



}
