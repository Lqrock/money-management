package com.bank.moneymanagement.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AspectExample {
    private static final Logger logger = Logger.getLogger(AspectExample.class.getName());

//    @Pointcut("annotation(@Log)")
//    public void wtf(){}
//
//    @Before("wtf()")
//    public void lol(JoinPoint joinPoint) {
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");
//        System.out.println("LOG WORKING!!!");

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
//    }

}
