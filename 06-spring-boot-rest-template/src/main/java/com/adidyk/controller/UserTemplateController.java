package com.adidyk.controller;

import com.adidyk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
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
     * findAllUser - returns all user in string format.
     * @return - returns all user in string format.
     */
    @RequestMapping(value = "/template/find_all_user/string_format")
    public String findAllUserStringFormat() {
        String result = this.restTemplate.getForObject("http://localhost:8081/find_all_user", String.class);
        System.out.println("String result: " + result);
        return result;
    }

    /**
     * findAllUser - returns all user in string format.
     * @return - returns all user in string format.
     */
    @RequestMapping(value = "/template/find_all_user/object_format")
    public List<User> findAllUserList() {
       User[] users = this.restTemplate.getForObject("http://localhost:8081/find_all_user", User[].class);
        return Arrays.asList(Objects.requireNonNull(users));
    }

    /*
    @RequestMapping(value = "/template/find_all_user/json_format")
    public List<User> findAllUserJSONFormat() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String response = this.restTemplate.exchange("http://localhost:8081/find_all_user", HttpMethod.GET, entity, String.class).getBody();

        return response;
    }
    */

}
