package com.adidyk.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class TypeTransport used for creates new object type transport with params: id, name.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 09.10.2020.
 * @version 1.0.
 */
@Entity
@Table(name = "type_transport")
public class TypeTrasport {

    /**
     * @param id - type product id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param name - name of type product.
     */
    @Column(name = "name")
    private String name;

    /**
     * @param products - products.
     */
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "type")
    private List<Transport> transport = new ArrayList<>();

    /**
     * TypeTransport - constructor.
     */
    public TypeTrasport() {
    }

    /**
     * TypeProduct - constructor.
     * @param id - type product id.
     * @param name - name of type product.
     */
    public TypeTrasport(int id, String name) {
        this.name = name;
    }


}
