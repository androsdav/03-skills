package com.adidyk.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

/**
 * Class User used for creates new object user with params: id, login, password.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 27.01.2020.
 * @version 1.0.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * @param id - user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * @param login - user login.
     */
    @Column(name = "login")
    @NotBlank(message = "login is mandatory")
    private String login;

    /**
     * @param password - user password.
     */
    @Column(name = "password")
    @NotBlank(message = "password is mandatory")
    private String password;

    /**
     * User - constructor.
     */
    public User() {
    }

    /**
     * User - constructor.
     * @param id - user id.
     * @param login - user login.
     * @param password - user password.
     */
    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    /**
     * User - constructor.
     * @param id - user id.
     */
    public User(int id) {
        this.id = id;
    }

    /**
     * User - constructor.
     * @param login - user login.
     * @param password - user password.
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * getId - returns user id.
     * @return - returns user id.
     */
    public int getId() {
        return id;
    }

    /**
     * setId - sets user id.
     * @param id - user id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getLogin - returns user login.
     * @return - returns user login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * setLogin - sets user login.
     * @param login - user login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * getPassword - returns user password.
     * @return - returns user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword - sets user password.
     * @param password - user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * equals - returns boolean result.
     * @param o - object of class Object.
     * @return - returns "true" if id, login, password, of user is same, and returns "false" - isn`t same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    /**
     * hashCode - returns hash code for user.
     * @return - returns hash code for user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }

    /**
     * toString - returns string format.
     * @return - returns all information for user.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}