package com.adidyk.controller;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Class UserController.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@Controller
public class UserController {

    /**
     * @param service - service.
     */
    private UserService service;

    /**
     * UserController - constructor.
     * @param service - service.
     */
    UserController(UserService service) {
        this.service = service;
    }

    /**
     * addUser - adds user.
     * @param user - user.
     * @param result - result.
     * @param model - model.
     * @return - returns page.
     */
    @PostMapping("/saveUser")
    public String saveUser(@Valid User user, BindingResult result, Model model) {
        this.service.save(user);
        return "index";
    }

}