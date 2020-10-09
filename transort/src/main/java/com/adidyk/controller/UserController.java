package com.adidyk.controller;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
    }

    /**
     * findUserById - find user by id.
     * @param id - user id.
     * @return - returns user by id.
     */
    @RequestMapping(value = "/find_user_by_id/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findUserById(@PathVariable("id") int id) {
        User user = this.userService.findUserById(new User(id));
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * findUserById - finds user by id.
     * @param user - user.
     * @return - returns user by id.
     */
    @RequestMapping(value = "/find_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> findUserById(@RequestBody User user) {
        User userDB = this.userService.findUserById(user);
        if (userDB == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDB, HttpStatus.OK);
    }

    /**
     * updateUser - update user by id.
     * @param user - user.
     * @return - returns updated user.
     */
    @RequestMapping(value = "/update_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.updateUser(user), HttpStatus.OK);
    }

    /**
     * updateUserByIdPUT - updates user by id.
     * @param id - user id.
     * @param user - user.
     * @return - returns user update.
     */
    @RequestMapping(value = "update_user_by_id/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUserByIdPUT(@PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        return new ResponseEntity<>(this.userService.updateUser(user), HttpStatus.OK);
    }

    /**
     * deleteUserById - delete user by id.
     * @param user - user.
     * @return - returns deleted user.
     */
    @RequestMapping(value = "/delete_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> deleteUserById(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.deleteUser(user), HttpStatus.OK);
    }

    /**
     * deleteUsrById - delete user by id.
     * @param id - user id.
     * @return - returns deleted user.
     */
    @RequestMapping(value = "/delete_user_by_id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id) {
        return new ResponseEntity<>(this.userService.deleteUser(new User(id)), HttpStatus.OK);
    }

    /**
     * findAllUser - finds and returns list user.
     * @return - returns list user.
     */
    @RequestMapping(value = "/find_all_user", method = RequestMethod.GET)
    public List<User> findAllUser() {
        return this.userService.findAllUser();
    }

    /**
     * findAllUser - finds and returns list user.
     * @return - returns list user.
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public List<User> test() {
        return this.userService.findAllUser();
    }

    @GetMapping("/hello")
    public Collection<String> sayHello() {
        return IntStream.range(0, 10)
                .mapToObj(i -> "Hello number " + i)
                .collect(Collectors.toList());
    }

}