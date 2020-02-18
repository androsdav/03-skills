package com.adidyk.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UserTest {


    /**
     * @param userExpected - user.
     */
    private final User userExpected = new User(1, "man", "111");

    /**
     * @param userActual - user.
     */
    private final User userActual = new User(1, "man", "111");

    /**
     * getIdTest - tests method getId.
     */
    @Test
    public void getIdTest() {
        assertThat(1, is(this.userExpected.getId()));
    }

    /**
     * setIdTest - tests method setId.
     */
    @Test
    public void setIdTest() {
        this.userExpected.setId(2);
        assertThat(2, is(this.userExpected.getId()));
    }

    /**
     * getLoginTest - tests method getLogin.
     */
    @Test
    public void getLoginTest() {
        assertThat("man", is(userExpected.getLogin()));
    }

    /**
     * setLoginTest - tests method setLogin.
     */
    @Test
    public void setLoginTest() {
        this.userExpected.setLogin("woman");
        assertThat("woman", is(userExpected.getLogin()));
    }

    /**
     * getPasswordTest - test method getPassword.
     */
    @Test
    public void getPasswordTest() {
        assertThat("111", is(this.userExpected.getPassword()));
    }

    /**
     * setPasswordTest - tests method setPassword.
     */
    @Test
    public void setPasswordTest() {
        this.userExpected.setPassword("123");
        assertThat("123", is(this.userExpected.getPassword()));
    }

    /**
     * equalsTest - test method equals.
     */
    @Test
    public void equalsTest() {
        assertThat(this.userActual, is(this.userExpected));
    }

    /**
     * hashCodeTest - test method hashCode.
     */
    @Test
    public void hashCodeTest() {
        assertThat(this.userActual.hashCode(), is(this.userExpected.hashCode()));
    }

    /**
     * toStringTest - test method toString.
     */
    @Test
    public void toStringTest() {
        assertThat(this.userActual.toString(), is(this.userExpected.toString()));

    }

}