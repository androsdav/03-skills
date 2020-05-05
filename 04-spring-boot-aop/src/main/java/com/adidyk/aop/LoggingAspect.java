package com.adidyk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class ThreadService.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.04.2020.
 * @version 1.0.
 */
@Service
@Aspect
public class LoggingAspect {

    /**
     * @param logger - logger.
     */
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * logAfterAllNameMethodInStorageService - logs all name methods in within StorageService after doing.
     * @param joinPoint - join point.
     */
    /*
    @After("within(com.adidyk.service.StorageService)")
    public void logAfterAllNameMethodInStorageService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logAfterAllNameMethodInPackageService - logs all name methods in within StorageService after doing.
     * @param joinPoint - join point.
     */
    /*
    @After("within(com.adidyk.service.*)")
    public void logAfterAllNameMethodInPackageService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    /*
    @After("execution(public double com.adidyk.service.CalculateService.addition(double, double))")
    public void logAfterCalculateServiceMethodNameAddition(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    /*
    @After("execution(*String com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateServiceTypeString(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    /*
    @After("execution(*Double com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateServiceTypeDouble(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    /*
    @After("execution(public* com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateServicePublic(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    /*
    @After("execution(public String com.adidyk.service.CalculateService.*(String, ..))")
    public void logAfterAllNameMethodCalculateServicePublicFirstParamString(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */
    /*
    @After("execution(public* com.adidyk.service.CalculateService.*(*, Double, ..))")
    public void logAfterAllNameMethodCalculateServiceSecondParamDouble(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */




    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param joinPoint - join point.
     */

    @After("execution(* com.adidyk.service.CalculateService.*(..))")
    public void logAfterAllNameMethodCalculateService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(public Integer com.adidyk.service.StorageService.get(int)))", returning = "result")
    public void logAfterReturning(Object result, JoinPoint joinPoint) {
        logger.log(Level.WARNING, "returning value: " + result);
    }


    /**
     * logAfterCalculateService - logs name method addition of class CalculateService.
     * @param proceedingJoinPoint - join point.
     */
  /*
    @Around(value = "execution(* com.adidyk.service.CalculateService.*(..))")
    public Object logResultForAllMethodCalculateService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        //Measure method execution time
        stopWatch.start();
        Object timeResult = proceedingJoinPoint.proceed();
        stopWatch.stop();
        logger.log(Level.INFO, "[INFO]: " + className + "." + methodName + ": " + stopWatch.getTotalTimeMillis() + "ms");
        return timeResult;
    }


*/
    /*
    /**
     * logMethodCall - logs all name methods in within StorageService after doing.
     * @param joinPoint - join point.
     */
    /*
    @After("within(com.adidyk.service.StorageService)")
    public void logAfterAllNameMethodInPackage(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /*
    /**
     * logAfterReturning - log after returning.
     *
     * @param result - result.
     */

    /*
    @AfterReturning(pointcut = "execution(public Integer com.adidyk.service.StorageService.get(int))", returning = "result")
    public void logAfterReturning(Object result) {
        logger.log(Level.WARNING, "returning value: " + result.toString());
    }
    */


}
/*
//@After("stringProcessingMethod()")

//public void logMethodSum(JoinPoint joinPoint) {

//logger.log(Level.INFO, "name methof: " + joinPoint.getSignature().getDeclaringTypeName());

//

//}

/*/
