package com.bank.moneymanagement.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectExample {

    @Pointcut("@annotation(Log)")
    public void wtf(){}

    @Before("wtf()")
    public void lol() {
    }

}
