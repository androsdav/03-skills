package com.adidyk.controller;

import com.adidyk.model.User;
import com.adidyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
        try {
            return new ResponseEntity<>(this.userService.saveUser(user), HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * findUserById - find user by id.
     * @param id - user id.
     * @return - returns user by id.
     */
    @RequestMapping(value = "/find_user_by_id/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findUserById(@PathVariable("id") String id) {
        Optional<User> userDB = this.userService.findUserById(new User(id));
        return userDB.map(user1 -> new ResponseEntity<>(user1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * findUserById - finds user by id.
     * @param user - user.
     * @return - returns user by id.
     */
    @RequestMapping(value = "/find_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> findUserById(@RequestBody User user) {
        Optional<User> userDB = this.userService.findUserById(user);
        return userDB.map(user1 -> new ResponseEntity<>(user1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * updateUser - update user by id.
     * @param user - user.
     * @return - returns updated user.
     */
    @RequestMapping(value = "/update_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        Optional<User> userDB = this.userService.updateUser(user);
        return userDB.map(user1 -> new ResponseEntity<>(user1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * updateUserByIdPUT - updates user by id.
     * @param user - user.
     * @return - returns user update.
     */
    @RequestMapping(value = "update_user_by_id/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUserByIdPUT(@PathVariable("id") String id, @RequestBody User user) {
        user.setId(id);
        Optional<User> userDB = this.userService.updateUser(user);
        return userDB.map(user1 -> new ResponseEntity<>(user1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * deleteUserById - delete user by id.
     * @param user - user.
     * @return - returns deleted user.
     */
    @RequestMapping(value = "/delete_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> deleteUserById(@RequestBody User user) {
        Optional <User> userDB = this.userService.deleteUser(user);
        return userDB.map(user1 -> new ResponseEntity<>(user1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * deleteUsrById - delete user by id.
     * @param id - user id.
     * @return - returns deleted user.
     */
    @RequestMapping(value = "/delete_user_by_id/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUserById(@PathVariable("id") String id) {
        Optional <User> userDB = this.userService.deleteUser(new User(id));
        return userDB.map(user1 -> new ResponseEntity<>(user1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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