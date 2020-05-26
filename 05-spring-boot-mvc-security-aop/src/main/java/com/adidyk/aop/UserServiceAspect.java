package com.adidyk.aop;

import com.adidyk.model.User;
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
     * logAllMethodUserService - log all method user service.
     * @param joinPoint - join point.
     * @return - return proceed.
     * @throws Throwable - throwable.
     */
    @Around(value = "execution(* com.adidyk.service.UserService.*(..)) && args(user)", argNames = "joinPoint, user")
    public Object logAllMethodUserService(ProceedingJoinPoint joinPoint, User user) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        this.logger.log(Level.INFO, "[INFO]: " + joinPoint.getSignature() + "; user: " + user +  "; execution time: "
            + executionTime + "[ms]");
        System.out.println((char) 27 + "[31mWarning! " + (char)27 + "[0m");
        return proceed;
    }

    /**
     * logMethodGetAllUserService -log method get all user service.
     * @param joinPoint - join point.
     * @param result - result.
     */
    @AfterReturning(value = "execution(* com.adidyk.service.UserService.findAllUser())", returning = "result", argNames = "joinPoint,result")
    public void logMethodGetAllUserService(JoinPoint joinPoint,Object result) {
        this.logger.log(Level.INFO, "[INFO]: " + joinPoint.getSignature() + "; result: " + result);
    }

}