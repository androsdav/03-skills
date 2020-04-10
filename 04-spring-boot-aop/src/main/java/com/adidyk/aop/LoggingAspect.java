package com.adidyk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class ThreadService.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.04.2020.
 * @version 1.0.
 */
@Component
@Aspect
public class LoggingAspect {

    /**
     * @param logger - logger.
     */
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    /**
     * logMethodCall - log method call (return to logger name method).
     * @param joinPoint - join point.
     */
    @After("within(com.adidyk.service.StorageService)")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.log(Level.INFO, "name method: " + joinPoint.getSignature().getName());
    }

    /**
     * logAfterReturning - log after returnig.
     * @param joinPoint - join point.
     * @param result - result.
     */
    @AfterReturning(value = "execution(public Integer com.adidyk.service.StorageService.get(int))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.log(Level.INFO, "returning value: " + result.toString());
    }




    //

//@After("stringProcessingMethod()")

//public void logMethodSum(JoinPoint joinPoint) {

//logger.log(Level.INFO, "name methof: " + joinPoint.getSignature().getDeclaringTypeName());

//

//}

//

}