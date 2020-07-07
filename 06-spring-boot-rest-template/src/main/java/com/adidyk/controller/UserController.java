package com.adidyk.controller;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Class UserController.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@RestController
public class UserController {

    /**
     * @param userService - user service.
     */
    private UserService userService;

    /**
     * UserService - constructor.
     * @param userService - user service.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * saveUser - save new user.
     * @param user - user.
     */
    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        this.userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /**
     * findAllUser - finds and returns list user.
     * @return - returns list user.
     */
    @RequestMapping(value = "/find_all_user", method = RequestMethod.GET)
    public List<User> findAllUser() {
        return this.userService.findAllUser();
    }

}