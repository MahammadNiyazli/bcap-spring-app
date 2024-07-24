package com.company.bcapspringapp.aop;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class RequestResponseLogger {
    @Pointcut(value = "execution(* com.company.bcapspringapp.service.CustomerService.*(..))")
    public void customerService() {
    }

    @SneakyThrows
    @Around(value = "customerService()")
    public Object elapsedTimeLogger(ProceedingJoinPoint jp) {
        long startDate = System.currentTimeMillis();
        Object o = jp.proceed();
        long endDate = System.currentTimeMillis();
        System.err.println("Elapsed time: " + (endDate - startDate));
        return o;
    }

    @Before(value = "customerService()")
    public void logAllParameters(JoinPoint joinPoint) {
        Arrays.stream(
                joinPoint.getArgs()
        ).forEach(arg -> System.err.print("all method parameters : "+arg));
    }
}
