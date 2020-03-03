package com.adidyk.controller;

import com.adidyk.constant.Constant;
import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserService userService;


    /**
     * UserController - constructor.
     * @param userService - service.
     */
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }


    /*
    /**
     * addUser - adds user.
     * @return - returns page.
     */
    /*
    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public String saveUser(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("message");
        return constant.save;
    }

    /**
     * addUser - adds user.
     * @param user - user.
     * @param result - result.
     * @return - returns page.
     */
    /*
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            constant.url = constant.save;
            constant.message = "";
        } else {
            if (this.service.findByLogin(user) == null) {
                if (this.service.save(user) != null) {
                    constant.message = constant.newUserAdded;
                    constant.url = constant.index;
                } else {
                    constant.message = constant.newUserNotAdded;
                    constant.url = constant.save;
                }
            } else {
                constant.message = constant.enteredLoginIsDuplicated;
                constant.url = constant.save;
            }
        }
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("message", constant.message);
        return constant.url;
    }

    /**
     * addUser - adds user.
     * @return - returns page.
     */
    /*
    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = this.service.findById(new User(id));
        model.addAttribute("user", user);
        model.addAttribute("message");
        return constant.update;
    }

    /**
     * addUser - adds user.
     * @return - returns page.
     */
    /*
    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable int id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            constant.url = constant.update;
            constant.message = "";
        } else {
            if (this.service.findById(user) != null) {
                this.service.updateById(user);
                constant.message = constant.userUpdate;
                constant.url = constant.index;
            } else {
                constant.message = constant.userNotUpdate;
                constant.url = constant.update;
            }
        }
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("message", constant.message);
        return constant.url;
    }

    /**
     * deleteUserById - delete user by id.
     * @param id - user id.
     * @param model - model.
     * @return - return index.
     */
    /*
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUserById(@PathVariable("id") int id, Model model) {
        this.service.deleteById(new User(id));
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("message", constant.userDelete);
        return constant.index;
    }

    /**
     * findAllUser - finds all users.
     * @return - returns all users.
     */
    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findAllUser(Model model) {
        model.addAttribute("users", this.service.findAll());
        model.addAttribute("message", constant.getAllUser);
        return constant.index;
    }
    */

}