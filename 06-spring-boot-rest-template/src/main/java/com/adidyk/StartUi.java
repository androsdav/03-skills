package com.adidyk;

import com.adidyk.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Class StartUi. Start project.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class StartUi {

     /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        SpringApplication.run(StartUi.class, arg);
        System.out.println("TEST start project");
        User user = new User(1, "Ivan", "Ivanov");
        System.out.println(user);
    }

}