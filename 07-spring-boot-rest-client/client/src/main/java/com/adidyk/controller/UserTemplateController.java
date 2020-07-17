package com.adidyk.controller;

import com.adidyk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

/**
 * Class UserController.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@RestController
public class UserTemplateController {

    /**
     * @param restTemplate - rest template.
     */
    private final RestTemplate restTemplate;

    /**
     * UserTemplateController - user template controller.
     * @param restTemplate - rest template.
     */
    @Autowired
    public UserTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * saveUser - save new user.
     * @param user - user.
     */
    @RequestMapping(value = "/save_user", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return this.restTemplate.exchange("http://localhost:8081/save_user", HttpMethod.POST, entity, User.class);
    }

    /**
     * findUserById - find user by id.
     * @param user - user.
     * @return - returns user.
     */
    @RequestMapping(value = "/find_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> findUserById(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return this.restTemplate.exchange("http://localhost:8081/find_user_by_id", HttpMethod.POST, entity, User.class);
    }

    /**
     * updateUserById - find user by id.
     * @param user - user.
     * @return - returns user.
     */
    @RequestMapping(value = "/update_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> updateUserById(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return this.restTemplate.exchange("http://localhost:8081/update_user_by_id", HttpMethod.POST, entity, User.class);
    }

    /**
     * deleteUserById - delete user by id.
     * @param user - user.
     * @return - returns deleted user.
     */
    @RequestMapping(value = "/delete_user_by_id", method = RequestMethod.POST)
    public ResponseEntity<User> deleteUserById(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return this.restTemplate.exchange("http://localhost:8081/delete_user_by_id", HttpMethod.POST, entity, User.class);
    }

    /**
     * findAllUser - find all user exchange.
     * @return - return all user.
     */
    @RequestMapping(value = "/find_all_user", method = RequestMethod.GET)
    public ResponseEntity<String> findAllUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return this.restTemplate.exchange("http://localhost:8081/find_all_user", HttpMethod.GET, entity, String.class);
    }

}