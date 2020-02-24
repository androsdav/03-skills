package com.adidyk.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * Class User used for creates new object user with params: id, login, password.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 27.01.2020.
 * @version 1.0.
 */
@Entity
@Table(name = "users")
public class User implements UserDetails {

    /**
     * @param id - user id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * @param login - user login.
     */
    @Column(name = "login")
    @NotBlank(message = "login is mandatory")
    @Size(min = 3, message = "at least 3 characters")
    private String login;

    /**
     * @param password - user password.
     */
    @Column(name = "password")
    @NotBlank(message = "password is mandatory")
    @Size(min = 3, message = "at least 3 characters")
    private String password;

    /**
     * @param passwordConfirm - password confirm.
     */
    @Transient
    private String passwordConfirm;

    /**
     * @param roles - sets roles.
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
    private Set<Role> roles;

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
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * setPassword - sets user password.
     * @param password - user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getPasswordConfirm - gets password confirm.
     * @return - returns password confirm.
     */
    public String getPasswordConfirm() {
        return this.passwordConfirm;
    }

    /**
     *  setPasswordConfirm - sets apssword confirm.
     * @param passwordConfirm - user password confirm.
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * getRoles - gets set roles.
     * @return - returns set roles.
     */
    public Set<Role> getRoles() {
        return this.roles;
    }

    /**
     * setRole - sets role.
     * @param roles - roles.
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    @Override
    public String getUsername() {
        return this.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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
                Objects.equals(password, user.password) &&
                Objects.equals(passwordConfirm, user.passwordConfirm) &&
                Objects.equals(roles, user.roles);
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
                ", roles='" + roles + '\'' +
                '}';
    }

}