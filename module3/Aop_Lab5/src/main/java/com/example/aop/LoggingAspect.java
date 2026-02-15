package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.app.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBefore(JoinPoint jp) {
        logger.info("Before method: " + jp.getSignature());
    }

    @After("serviceMethods()")
    public void logAfter(JoinPoint jp) {
        logger.info("After method: " + jp.getSignature());
    }

    @AfterReturning(
            value = "execution(* com.app.service.BookService.getBook(..))",
            returning = "result")
    public void logReturn(Object result) {
        logger.info("Method returned: " + result);
    }

    @AfterThrowing(
            value = "serviceMethods()",
            throwing = "ex")
    public void logException(Exception ex) {
        logger.error("Exception thrown: " + ex.getMessage());
    }
}
