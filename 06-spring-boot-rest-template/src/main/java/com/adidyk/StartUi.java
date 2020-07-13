package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

/**
 * Class StartUi. Start project. :-(
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class StartUi {

    /**
     * getRestTemplate - gets link to object class RestTemplate.
     * @return - returns link to object of class RestTemplate.
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

     /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        SpringApplication.run(StartUi.class, arg);
    }

}