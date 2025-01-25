package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging
    // let's start with a @Before advice
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void  com.luv2code.aopdemo.dao.AccountDAOImpl.addAccount())") // only called for AccountDAO
//    @Before("execution(public void add*())") // match any method starts with add
//    @Before("execution(void add*())") // match return type void
//    @Before("execution(* add*())") // match any method with any return type
//    @Before("execution(* add*(com.luv2code.aopdemo.Account))") // match method with one argument of any type
    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // match method with 0 or more argument of any type
    public void beforeAddAccountAdvice() {
        System.out.println("\n=========>>> Executing @Before advice on addAccount()");
    }
}
