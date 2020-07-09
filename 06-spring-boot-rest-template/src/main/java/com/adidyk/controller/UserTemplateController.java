package com.adidyk.controller;

import com.adidyk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
     * ---- GET -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> string format.
     * @return - returns all user in string format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_object/string", method = RequestMethod.GET)
    public String findAllUserStringFormat() {
        return this.restTemplate.getForObject("http://localhost:8081/find_all_user", String.class);
    }

    /**
     * ---- GET 1 -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> user format.
     * @return - returns all user in json format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_object/object", method = RequestMethod.GET)
    public List<User> findAllUserList() {
       User[] users = this.restTemplate.getForObject("http://localhost:8081/find_all_user", User[].class);
       return Arrays.asList(Objects.requireNonNull(users));
    }

    /**
     * ---- GET 2 -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> user format.
     * @return - returns all user in json format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_object/response", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUserResponseEntity() {
        User[] users = this.restTemplate.getForObject("http://localhost:8081/find_all_user", User[].class);
        return new ResponseEntity<>(Arrays.asList(Objects.requireNonNull(users)), HttpStatus.OK);
    }

    /**
     * ---- GET 3 -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> entity.
     * @return - returns all user in json format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_entity/entity", method = RequestMethod.GET)
    public ResponseEntity<String> findAllUserEntity() {
        return this.restTemplate.getForEntity("http://localhost:8081/find_all_user", String.class);
    }

    /**
     * ---- GET 4 -----
     * findAllUserExchange - find all user exchange.
     * exchange - support request headers.
     * @return - return string format.
     */
    @RequestMapping(value = "/template/find_all_user/exchange/json", method = RequestMethod.GET)
    public ResponseEntity<String> findAllUserExchange() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return this.restTemplate.exchange("http://localhost:8081/find_all_user", HttpMethod.GET, entity, String.class);
    }

    /**
     * ---- GET 5 -----
     * findUserById - find user by id.
     * @return - returns user.
     */
    @RequestMapping(value = "/template/find_user_by_id", method = RequestMethod.GET)
    public User findUserById(@RequestBody User user) {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(user.getId()));
        return this.restTemplate.getForObject("http://localhost:8081/find_user_by_id/{id}", User.class, params);
    }

}