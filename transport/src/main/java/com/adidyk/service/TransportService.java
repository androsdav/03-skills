package com.adidyk.service;

import com.adidyk.model.Transport;
import com.adidyk.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Class TransportService used for access to data base.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 09.10.2020.
 * @version 1.0.
 */
@Service
public class TransportService {

    /**
     * @param transportRepository - transport repository.
     */
    private TransportRepository transportRepository;

    /**
     * TransportService - constructor.
     * @param transportRepository - transport repository.
     */
    @Autowired
    TransportService(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    /**
     * findAllTransportByPriceAndByType - finds all transport by price and type of transport and returns
     * list result search.
     * @param price - price transport.
     * @param type - type transport.
     * @return - returns list result search.
     */
    public Optional<List<Transport>> findAllTransportByPriceAndByType(Float price, String type) {
        return this.transportRepository.findAllTransportByPriceAndByType(price, type);
    }

    /**
     * findAllTransport - finds all transport and returns all result (list transport) search.
     * @return - returns all result (list transport) search.
     */
    public Optional<List<Transport>> findAllTransport() {
        return this.transportRepository.findAllTransport();
    }

}