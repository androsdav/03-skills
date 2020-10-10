package com.adidyk.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * Class TypeTransport used for creates new object type transport with params: id, name.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 09.10.2020.
 * @version 1.0.
 */
@Entity
@Table(name = "transport")
public class Transport {

    /**
     * @param id - transport id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param name - transport name.
     */
    @Column(name = "name")
    private String name;

    /**
     * @param price - transport price.
     */
    @Column(name = "price")
    private Float price;

    /**
     * @param dateCreate - time adds to data base object of class Transport.
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "date_create")
    private Date dateCreate = new Date();

    /**
     * @param typeTransport - type transport.
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "type_transport_id")
    private TypeTransport typeTransport;

    /**
     * Transport - constructor.
     */
    Transport() {
    }

    /**
     * getId - returns transport id.
     * @return - returns transport id.
     */
    public int getId() {
        return id;
    }

    /**
     * setId - sets transport id.
     * @param id -transport id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getName - gets transport name.
     * @return - gets transport name.
     */
    public String getName() {
        return name;
    }

    /**
     * setName - sets transport name.
     * @param name - transport name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getPrice - gets transport price.
     * @return - gets transport price.
     */
    public Float getPrice() {
        return price;
    }

    /**
     * setPrice - sets transport price.
     * @param price - transport price.
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * getDateCreate - gets dae ceate.
     * @return - gets date create.
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * setDateCreate - sets date create.
     * @param dateCreate - transport date create in data base.
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * getTypeTransport - gets type transport.
     * @return - gets type transport.
     */
    public TypeTransport getTypeTransport() {
        return typeTransport;
    }

    /**
     * setTypeTransport - sets type transport.
     * @param typeTransport - type transport.
     */
    public void setTypeTransport(TypeTransport typeTransport) {
        this.typeTransport = typeTransport;
    }

    /**
     * equals - returns boolean result.
     * @param o - object of class Object.
     * @return - returns "true" if name of type transport is same,
     * and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(name, transport.name) &&
                Objects.equals(price, transport.price) &&
                Objects.equals(dateCreate, transport.dateCreate) &&
                Objects.equals(typeTransport, transport.typeTransport);
    }

    /**
     * hashCode - returns hash code for type transport.
     * @return - returns hash code for type transport.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, price, dateCreate, typeTransport);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for typ transport.
     */
    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", dateCreate=" + dateCreate +
                '}';
    }

}