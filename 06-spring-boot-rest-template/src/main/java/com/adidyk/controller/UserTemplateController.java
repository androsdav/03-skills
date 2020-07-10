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

    /*------------------------------------------ save new user -------------------------------------------------------*/
    /**
     * ---- POST NEW USER 1 ----
     * saveUser - save new user.
     * @param user - user.
     */
    @RequestMapping(value = "/template/save_user_first", method = RequestMethod.POST)
    public User saveUserFirst(@RequestBody User user) {
        return this.restTemplate.postForObject("http://localhost:8081/save_user", user, User.class);
    }

    /**
     * ---- POST NEW USER 2 ----
     * saveUser - save new user.
     * @param user - user.
     */
    @RequestMapping(value = "/template/save_user_second", method = RequestMethod.POST)
    public ResponseEntity<User> saveUserSecond(@RequestBody User user) {
        return this.restTemplate.postForEntity("http://localhost:8081/save_user", user, User.class);
    }

    /**
     * ---- POST NEW USER 3 ----
     * saveUser - save new user.
     * @param user - user.
     */
    @RequestMapping(value = "/template/save_user_third", method = RequestMethod.POST)
    public ResponseEntity<User> saveUserThird(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return this.restTemplate.exchange("http://localhost:8081/save_user", HttpMethod.POST, entity, User.class);
    }

    /*----------------------------------------- find user by id ------------------------------------------------------*/
    /**
     * ---- GET BY ID 1 -----
     * findUserById - find user by id.
     * @return - returns user.
     */
    @RequestMapping(value = "/template/find_user_by_id/{id}", method = RequestMethod.GET)
    public User findUserByIdFirst(@PathVariable("id") int id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        return this.restTemplate.getForObject("http://localhost:8081/find_user_by_id/{id}", User.class, params);
    }

    /**
     * ---- GET BY ID 2 -----
     * findUserById - find user by id.
     * @return - returns user.
     */
    @RequestMapping(value = "/template/find_user_by_id/second", method = RequestMethod.POST)
    public User findUserByIdSecond(@RequestBody User user) {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(user.getId()));
        return this.restTemplate.getForObject("http://localhost:8081/find_user_by_id/{id}", User.class, params);
    }

    /**
     * ---- GET BY ID 3 -----
     * findUserById - find user by id.
     * @return - returns user.
     */
    @RequestMapping(value = "/template/find_user_by_id/third", method = RequestMethod.POST)
    public User findUserByIdThird(@RequestBody User user) {
        return this.restTemplate.postForObject("http://localhost:8081/find_user_by_id", user, User.class);
    }

    /**
     * ---- GET BY ID 4 -----
     * findUserById - find user by id.
     * @return - returns user.
     */
    @RequestMapping(value = "/template/find_user_by_id/fourth", method = RequestMethod.POST)
    public ResponseEntity<User> findUserByIdFourth(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return this.restTemplate.exchange("http://localhost:8081/find_user_by_id", HttpMethod.POST, entity, User.class);
    }

    /*---------------------------------------- update user by id -----------------------------------------------------*/
    /**
     * ---- POST UPDATE BY ID 3 -----
     * findUserById - find user by id.
     * @return - returns user.
     */
    @RequestMapping(value = "/template/update_user_by_id/first", method = RequestMethod.POST)
    public User updateUserByIdFirst(@RequestBody User user) {
        return this.restTemplate.postForObject("http://localhost:8081/update_user_by_id", user, User.class);
    }

    /**
     * ---- GET BY ID 4 -----
     * findUserById - find user by id.
     * @return - returns user.
     */
    @RequestMapping(value = "/template/update_user_by_id/second", method = RequestMethod.POST)
    public ResponseEntity<User> updateUserByIdSecond(@RequestBody User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return this.restTemplate.exchange("http://localhost:8081/update_user_by_id", HttpMethod.POST, entity, User.class);
    }

    /*----------------------------------------- Find all user --------------------------------------------------------*/
    /**
     * ---- GET ALL 1 -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> string format.
     * @return - returns all user in string format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_object/string", method = RequestMethod.GET)
    public String findAllUserStringFormat() {
        return this.restTemplate.getForObject("http://localhost:8081/find_all_user", String.class);
    }

    /**
     * ---- GET ALL 2 -----
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
     * ---- GET ALL 3 -----
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
     * ---- GET ALL 4 -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> entity.
     * @return - returns all user in json format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_entity/entity", method = RequestMethod.GET)
    public ResponseEntity<String> findAllUserEntity() {
        return this.restTemplate.getForEntity("http://localhost:8081/find_all_user", String.class);
    }

    /**
     * ---- GET ALL 5 -----
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

}