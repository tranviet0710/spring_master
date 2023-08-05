package com.eazybytes.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * @author VietDev
 * @date 04/08/2023
 * @role
 */
@Slf4j
@Component
@Aspect
public class LoggerAspect {

    @Around("execution(* com.eazybytes..*.*(..))")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info(proceedingJoinPoint.getSignature().toString() + " method execution start.");
        Instant start = Instant.now();
        Object returnObj = proceedingJoinPoint.proceed();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        log.info("Time took to execute " + proceedingJoinPoint.getSignature().toString() + " method is : " + timeElapsed);
        log.info(proceedingJoinPoint.getSignature().toString() + " method execution end");
        return returnObj;
    }

    @AfterThrowing(value = "execution(* com.eazybytes.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error(joinPoint.getSignature() + " An exception happened due to : " + ex.getMessage());
    }
}

