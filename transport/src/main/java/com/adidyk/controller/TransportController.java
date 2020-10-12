package com.adidyk.controller;

import com.adidyk.model.Transport;
import com.adidyk.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class TransportController.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@RestController
public class TransportController {

    /**
     * @param transportService - transport service.
     */
    private TransportService transportService;

    /**
     * TransportController - constructor.
     * @param transportService - transport service.
     */
    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    /**
     * findAllTransportByPriceAndByType - finds all transport by price and type of transport and returns
     * list result search.
     * @param price - price transport.
     * @param type - type transport.
     * @return - returns list result search.
     */
    @RequestMapping(value = "/transport/", method = RequestMethod.GET)
    public ResponseEntity<List<Transport>> findAllTransportByPriceAndByType(@RequestParam("price") Float price, @RequestParam("type") String type) {
        Optional<List<Transport>> result = this.transportService.findAllTransportByPriceAndByType(price, type);
        return result.map(transports -> new ResponseEntity<>(transports, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * findAllTransport - finds all transport and returns all result (list transport) search.
     * @return - returns all result (list transport) search.
     */
    @RequestMapping(value = "/transport", method = RequestMethod.GET)
    public ResponseEntity<List<Transport>> findAllTransport() {
        Optional<List<Transport>> result = this.transportService.findAllTransport();
        return result.map(transports -> new ResponseEntity<>(transports, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}