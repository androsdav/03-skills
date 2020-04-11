package com.adidyk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;
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

    /*
    /**
     * logMethodCall - logs all name methods in within StorageService after doing.
     * @param joinPoint - join point.
     */
    /*
    @After("within(com.adidyk.service.StorageService)")
    public void logAfterAllNameMethodInStorageService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }
    */

    /**
     * logMethodCall - logs all name methods in within StorageService after doing.
     * @param joinPoint - join point.
     */
    @After("within(com.adidyk..*)")
    public void logAfterAllNameMethodInPackageService(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getClass().getName());
    }


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
