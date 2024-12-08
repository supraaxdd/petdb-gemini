package com.supra.petdbgemini.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.supra.petdbgemini.service.*.*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Entering method: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Exiting method: {} (Execution time: {} ms)", joinPoint.getSignature(), endTime - startTime);
        return result;
    }
}