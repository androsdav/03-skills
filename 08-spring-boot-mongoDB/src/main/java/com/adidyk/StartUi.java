package com.adidyk;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class StartUi. Start project. :-(
 */
@SpringBootApplication

public class StartUi implements CommandLineRunner {

    /**
     * @pram userService - user serice.
     */
    private UserService userService;

    /**
     * StartUi - constructor.
     * @param userService - user service.
     */
    @Autowired
    public StartUi(UserService userService) {
        this.userService = userService;
    }

    /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        SpringApplication.run(StartUi.class, arg);
    }

    @Override
    public void run(String... args) throws Exception {
       // User user = new User("Bred", "Pitt");
       // this.userService.saveUser(user);

    }
}