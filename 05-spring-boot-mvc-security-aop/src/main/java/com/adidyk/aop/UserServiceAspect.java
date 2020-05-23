package com.adidyk.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;


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



}
