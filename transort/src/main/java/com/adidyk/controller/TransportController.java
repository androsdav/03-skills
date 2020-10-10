package com.adidyk.controller;

import com.adidyk.model.Transport;
import com.adidyk.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    @RequestMapping(value = "/find_all_transport_by_price_and_type/{price}/{type}", method = RequestMethod.GET)
    public List<Transport> findAllTransportByPriceAndByType(@PathVariable("price") Float price,
                                                            @PathVariable("type") String type) {
        return this.transportService.findAllTransportByPriceAndByType(price, type);
    }

    /**
     * findAllTransport - finds all transport and returns all result (list transport) search.
     * @return - returns all result (list transport) search.
     */
    @RequestMapping(value = "/find_all_transport", method = RequestMethod.GET)
    public List<Transport> findAllTransport() {
        return this.transportService.findAllTransport();
    }

}