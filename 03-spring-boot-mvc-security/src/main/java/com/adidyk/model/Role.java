package com.adidyk.model;

import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.*;

/**
 * Class Role used for creates new object role with params: id, name.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 27.01.2020.
 * @version 1.0.
 */
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    /**
     * @param id - role id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * @param name - role name.
     */
    @Column(name = "name", unique = true)
    private String name;

    /**
     * @param users - list user.
     */
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    /**
     * Role - constructor.
     */
    public Role() {
    }

    /**
     * getId - returns id role.
     * @return - returns id role.
     */
    public int getId() {
        return id;
    }

    /**
     * setId - sets id role.
     * @param id -  role id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getName - returns name role.
     * @return - returns name role.
     */
    public String getName() {
        return name;
    }

    /**
     * setName - sets name rle.
     * @param name - name role.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getUsers - returns list users.
     * @return - returns list users.
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * setUsers - sets list users.
     * @param users - list user.
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * getAuthority - gets name role.
     * @return - returns name role.
     */
    @Override
    public String getAuthority() {
        return this.getName();
    }

    /**
     * equals - returns boolean result.
     * @param o - object of class Object.
     * @return - returns "true" if id, login, password, list user of role is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(name, role.name) &&
                Objects.equals(users, role.users);
    }

    /**
     * hashCode - returns hash code for user.
     * @return - returns hash code for user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, users);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}