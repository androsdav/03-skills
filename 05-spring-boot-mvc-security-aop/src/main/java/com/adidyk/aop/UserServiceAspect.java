package com.adidyk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class UserServiceAspect, used different aspect, pointcut and joinPoint.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 23.05.2020.
 * @version 1.0.
 */
@Aspect
@Configuration
public class UserServiceAspect {

    /**
     * @param logger - logger.
     */
    private Logger logger = Logger.getLogger(UserServiceAspect.class.getName());

    /**
     * logAllMethofUserService - log all method user service.
     * @param joinPoint - join point.
     * @return - return method result.
     * @throws Throwable - throwable.
     */
    @Around(value = "execution(* com.adidyk.service.UserService.*(..))")
    public Object logAllMethodUserService(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        this.logger.log(Level.INFO, "[INFO]: " + joinPoint.getSignature() + "; execution time: "
                + executionTime + "[ms]");
        return  proceed;
    }

    /**
     * logAllMethodUserServiceReturning - log all method user service returning.
     * @param joinPoint - join point.
     * @param result - result.
     */
    @AfterReturning(value = "execution(* com.adidyk.service.UserService.*(..))", returning = "result")
    public void logAllMethodUserServiceReturning(JoinPoint joinPoint, Object result) {
        this.logger.log(Level.INFO, "[INFO]: " + joinPoint + "; returning: " + result.toString());

    }

}