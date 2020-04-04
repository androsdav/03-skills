package com.adidyk.controller;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class AdminController for administering users for user with administrator role.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@Controller
public class AdminController {

    /**
     * @param userService - user service.
     */
    private UserService userService;

    /**
     * AdminController - constructor.
     * @param userService - user service.
     */
    @Autowired
    private AdminController(UserService userService) {
        this.userService = userService;
    }

    /**
     * deleteUserById - delete user by id.
     * @param id - user id.
     * @param model - model.
     * @return - returns page admin.
     */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUserById(@PathVariable int id, Model model) {
        if (!this.userService.deleteUserById(new User(id))) {
            model.addAttribute("userDeleteError", "user was not delete, because user by id was not found");
            model.addAttribute("users", this.userService.findAllUser());
            return "admin";
        }
        model.addAttribute("userDelete", "user was delete");
        model.addAttribute("users", this.userService.findAllUser());
        return "admin";
    }

    /**
     * findAllUser - finds all user.
     * @param model - model.
     * @return - returns page admin.
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String findAllUser(Model model) {
        model.addAttribute("users", this.userService.findAllUser());
        return "admin";
    }

}