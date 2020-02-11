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

    @Value("${message.enteredLoginIsDuplicated}")
    private String enteredLoginIsDuplicated;

    @Value("${message.newUserAdded}")
    private String newUserAdded;

    @Value("${message.newUserNotAdded}")
    private String newUserNotAdded;

    /**
     * UserController - constructor.
     * @param service - service.
     */
    UserController(UserService service) {
        this.service = service;
    }

    /**
     * addUser - adds user.
     * @return - returns page.
     */
    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String saveUser(Model model) {
        model.addAttribute("saveUser", new User());
        return "index";
    }
    */

    /**
     * addUser - adds user.
     * @param saveUser - user.
     * @param result - result.
     * @return - returns page.
     */
    @RequestMapping(value = "/save-user", method = RequestMethod.POST)
    public String saveUser(@Valid User saveUser, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if (this.service.findByLogin(saveUser) == null) {
                if (this.service.save(saveUser) != null) {
                    model.addAttribute("message", newUserAdded);
                } else {
                    model.addAttribute("message", newUserNotAdded);
                }
            } else {
                model.addAttribute("message", enteredLoginIsDuplicated);
            }
        }
        model.addAttribute("users", this.service.findAll());
        return "index";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUserById(@Valid User user, BindingResult result, Model model) {
        System.out.println();
        System.out.println("user: " + user);
        System.out.println();
        this.service.deleteById(user);
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