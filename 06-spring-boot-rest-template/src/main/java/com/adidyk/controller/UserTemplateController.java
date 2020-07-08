package com.adidyk.controller;

import com.adidyk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    @RequestMapping(value = "/template/find_all_user/get_for_object/string")
    public String findAllUserStringFormat() {
        String result = this.restTemplate.getForObject("http://localhost:8081/find_all_user", String.class);
        System.out.println("String result: " + result);
        return result;
    }

    /**
     * ---- GET -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> user format.
     * @return - returns all user in json format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_object/object")
    public List<User> findAllUserList() {
       User[] users = this.restTemplate.getForObject("http://localhost:8081/find_all_user", User[].class);
       return Arrays.asList(Objects.requireNonNull(users));
    }

    /**
     * ---- GET -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> user format.
     * @return - returns all user in json format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_object/response")
    public ResponseEntity<List<User>> findAllUserResponseEntity() {
        User[] users = this.restTemplate.getForObject("http://localhost:8081/find_all_user", User[].class);
        return new ResponseEntity<>(Arrays.asList(Objects.requireNonNull(users)), HttpStatus.OK);
    }

    /**
     * ---- GET -----
     * findAllUser - returns all user in string format.
     * getForObject - get for object -> entity.
     * @return - returns all user in json format.
     */
    @RequestMapping(value = "/template/find_all_user/get_for_entity/string")
    public ResponseEntity<String> findAllUserEntity() {
        ResponseEntity<String> responseEntity = this.restTemplate.getForEntity("http://localhost:8081/find_all_user", String.class);
        return responseEntity;
    }

    /**
     * ---- GET -----
     * findAllUserExchange - find all user exchange.
     * exchange - support request headers.
     * @return - return string format.
     */
    @RequestMapping(value = "/template/find_all_user/json_format")
    public ResponseEntity<String> findAllUserExchange() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = this.restTemplate.exchange("http://localhost:8081/find_all_user", HttpMethod.GET, entity, String.class);
        return response;
    }

}
