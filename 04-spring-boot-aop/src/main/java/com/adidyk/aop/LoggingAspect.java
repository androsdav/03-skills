package com.adidyk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class LogginAspect, uses different aspect, pointcut and joinPoint.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.04.2020.
 * @version 1.0.
 */
@Aspect
@Configuration
public class LoggingAspect {

    /**
     * @param logger - logger.
     */
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * logAfterAllNameMethodInStorageService - logs all name methods in within StorageService after doing.
     * @param joinPoint - join point.
     */
    @After("within(com.adidyk.service.StorageService)")
    public void logAfterAllNameMethodInStorageService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterAllNameMethodInPackageService - logs all name methods in within StorageService after doing.
     * @param joinPoint - join point.
     */
    @After("within(com.adidyk.service.*)")
    public void logAfterAllNameMethodInPackageService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    @After("execution(public double com.adidyk.service.CalculateService.addition(double, double))")
    public void logAfterCalculateServiceMethodNameAddition(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    @After("execution(*String com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateServiceTypeString(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    @After("execution(*Double com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateServiceTypeDouble(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    @After("execution(public* com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateServicePublic(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    @After("execution(public String com.adidyk.service.CalculateService.*(String, ..))")
    public void logAfterAllNameMethodCalculateServicePublicFirstParamString(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    @After("execution(public* com.adidyk.service.CalculateService.*(*, Double, ..))")
    public void logAfterAllNameMethodCalculateServiceSecondParamDouble(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    @After("execution(* com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterReturningAllMethodInStorageService - logs after returning all method in StorageService.
     * @param joinPoint - join point.
     * @param result - result.
     */
    @AfterReturning(pointcut = "execution(* com.adidyk.service.StorageService.*(..)))", returning = "result")
    public void logAfterReturningAllMethodInStorageService(JoinPoint joinPoint, Object result) {
        logger.log(Level.INFO, "method: " + joinPoint + "result:" + result);
    }

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param proceedingJoinPoint - join point.
     */
    @Around(value = "execution(* com.adidyk.service.StorageService.*(..))")
    public Object logResultForAllMethodCalculateService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object timeResult = proceedingJoinPoint.proceed();
        stopWatch.stop();
        logger.log(Level.INFO, "[INFO]: " + className + "." + methodName + ": " + stopWatch.getTotalTimeMillis() + "ms");
        return timeResult;
    }

    /**
     * logAllMethodInPackageService - logs all method in package service.
     * @param joinPoint - join point.
     * @return - returns object.
     * @throws Throwable - throws.
     */
    @Around(value = "execution(* com.adidyk.service.*.*(..)) && args(first, second)", argNames = "joinPoint,first,second")
    public Object logAllMethodInPackageService(ProceedingJoinPoint joinPoint, double first, double second) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.log(Level.INFO, "[INFO]: " + joinPoint.getSignature() + "; firstParam: " + first + "; secondParam: " + second + "; execution time: " + executionTime + "[ms]");
        return proceed;
    }

    /**
     * afterAdvice - after advice.
     * @param joinPoint - join point.
     * @param first - first.
     * @param second - second.
     */
    @After(value = "execution(* com.adidyk..service.CalculateService.*(..)) && args(first, second)", argNames = "joinPoint,first,second")
    public void afterAdvice(JoinPoint joinPoint, double first, double second) {
        logger.log(Level.INFO, "first: " + first + ", second: " + second);
        logger.log(Level.INFO, "method: " + joinPoint.getSignature());
    }

    /**
     * afterAdvice - after advice.
     * @param joinPoint - join point.
     * @param first - first.
     * @param second - second.
     */
    @Before(value = "execution(* com.adidyk.service.CalculateService.*(..)) && args(first, second)", argNames = "joinPoint,first,second")
    public void beforeAdvice(JoinPoint joinPoint, double first, double second) {
        logger.log(Level.INFO, "first: " + first + ", second: " + second);
        logger.log(Level.INFO, "method: " + joinPoint.getSignature());
    }

}