package com.bank.moneymanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Aspect
@Component
public class AspectExample {
    private static final Logger logger = Logger.getLogger(AspectExample.class.getName());

    @Pointcut("execution(* com.bank.moneymanagement..*(..))")
    public void wtf(){}

    @Before("wtf()")
    public void lol(JoinPoint joinPoint) {
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        String log = methodSignature.getMethod().getName();
//        try {
//            FileHandler fileHandler = new FileHandler("logfile.txt", true); // true for append mode
//            SimpleFormatter formatter = new SimpleFormatter();
//            fileHandler.setFormatter(formatter);
//            logger.addHandler(fileHandler);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        logger.warning(log);
    }

}
