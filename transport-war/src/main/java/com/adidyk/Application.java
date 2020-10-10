package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Class Application.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

     /**
     * main - run program.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        SpringApplication.run(Application.class, arg);
    }

}