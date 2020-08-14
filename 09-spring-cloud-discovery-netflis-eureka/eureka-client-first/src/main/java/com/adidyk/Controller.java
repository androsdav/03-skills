package com.adidyk;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    /**
     * getMassage - get message.
     * @return - returns message about first eureka client.
     */
    @RequestMapping(value = "/get_message", method = RequestMethod.GET)
    public ResponseEntity<String> getMassage() {
        return new ResponseEntity<>("is first eureka client", HttpStatus.OK);
    }

}