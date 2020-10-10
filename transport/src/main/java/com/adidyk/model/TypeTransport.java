package com.adidyk.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Class TypeTransport used for creates new object type transport with params: id, name.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 09.10.2020.
 * @version 1.0.
 */
@Entity
@Table(name = "type_transport")
public class TypeTransport {

    /**
     * @param id - type transport id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * @param name - name of type transport.
     */
    @Column(name = "name")
    private String name;

    /**
     * TypeTransport - constructor.
     */
    public TypeTransport() {
    }

    /**
     * TypeTransport - constructor.
     * @param id - type transport id.
     * @param name - name of type transport.
     */
    public TypeTransport(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * getId - returns type transport id.
     * @return - returns type transport id.
     */
    public int getId() {
        return id;
    }

    /**
     * setId - sets type transport id.
     * @param id - type transport id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getName - returns type transport name.
     * @return - returns type transport name.
     */
    public String getName() {
        return name;
    }

    /**
     * setName - sets type transport name.
     * @param name - type transport name.
     */
    public void setName(String name) {
        this.name = name;
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
        TypeTransport that = (TypeTransport) o;
        return Objects.equals(name, that.name);
    }

    /**
     * hashCode - returns hash code for type transport.
     * @return - returns hash code for type transport.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for typ transport.
     */
    @Override
    public String toString() {
        return "TypeTransport{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

}