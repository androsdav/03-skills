package com.adidyk.controller;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * findUserById - find user by id.
     * @param id - user id.
     * @return - returns user by id.
     */
    @RequestMapping(value = "/find_user_by_id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
        User user = this.userService.findUserById(new User(id));
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
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