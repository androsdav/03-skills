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
    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public String saveUser(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("message");
        return "save";
    }

    /**
     * addUser - adds user.
     * @param user - user.
     * @param result - result.
     * @return - returns page.
     */
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, Model model) {
        String message = "";
        String url;
        if (result.hasErrors()) {
            url = "save";
        } else {
            if (this.service.findByLogin(user) == null) {
                if (this.service.save(user) != null) {
                    message = newUserAdded;
                    url = "index";
                } else {
                    message = newUserNotAdded;
                    url = "save";
                }
            } else {
                message = enteredLoginIsDuplicated;
                url = "save";
            }
        }
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("message", message);
        return url;
    }

    /**
     * addUser - adds user.
     * @return - returns page.
     */
    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = this.service.findById(new User(id));
        model.addAttribute("user", user);
        model.addAttribute("message");
        return "update";
    }

    /**
     * addUser - adds user.
     * @return - returns page.
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(@Valid User user, Model model) {

        this.service.updateById(user);
        model.addAttribute("users", this.service.findAll());
        return "index";
    }

    /**
     * deleteUserById - delete user by id.
     * @param id - user id.
     * @param model - model.
     * @return - return index.
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUserById(@PathVariable("id") int id, Model model, User user) {
        this.service.deleteById(new User(id));
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("user", new User());
        return "index";
    }


    /**
     * findAllUser - finds all users.
     * @return - returns all users.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAllUser(Model model) {
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("user", new User(12, "test", "test"));
        model.addAttribute("message");
        return "index";
    }

}