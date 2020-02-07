package com.adidyk.controller;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @Value("${error.addFormIsEmpty}")
    private String addFormIsEmpty;

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
     * @return - returns page.
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", addFormIsEmpty);
        } else {
            this.service.save(user);
        }
        model.addAttribute("users", this.service.findAll());
        return "index";
    }

    /**
     * findAllUser - finds all users.
     * @return - returns all users.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAllUser(Model model) {
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("user", new User());
        return "index";
    }

}