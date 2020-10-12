package com.adidyk.repository;

import com.adidyk.model.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * Interface TransportRepository used for access to data base.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 09.10.2020.
 * @version 1.0.
 */
@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {

    /**
     * findAllTransportByPriceAndByType - finds all transport by price and type of transport and returns
     * list result search.
     * @param price - price transport.
     * @param type - type transport.
     * @return - returns list result search.
     */
    @Query(value = "select t from Transport as t inner join fetch t.typeTransport where (t.typeTransport.name = :type and t.price > :price)")
    Optional<List<Transport>> findAllTransportByPriceAndByType(@Param("price")Float price, @Param("type") String type);

    /**
     * findAllTransport - finds all transport and returns all result (list transport) search.
     * @return - returns all result (list transport) search.
     */
    @Query(value = "select t from Transport as t inner join fetch t.typeTransport")
    Optional<List<Transport>> findAllTransport();

}