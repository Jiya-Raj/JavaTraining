package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class PerformanceAspect {

    private static final Logger logger =
            LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.app.service.*.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp)
            throws Throwable {

        long start = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();

        logger.info("Execution Time of "
                + pjp.getSignature()
                + ": " + (end - start) + " ms");

        return result;
    }
}
