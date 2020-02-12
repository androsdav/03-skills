package com.adidyk.service;

import com.adidyk.model.User;
import com.adidyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class UserService.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@Service
public class UserService {

    /**
     * @param repository - repository.
     */
    private UserRepository repository;

    /**
     * UserService - constructor.
     * @param repository - repository.
     */
    @Autowired
    UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * save - adds user.
     * @param user - user.
     */
    public User save(User user) {
        return this.repository.save(user);
    }

    /**
     * findByLogin - finds user by login and returns.
     * @param user - user.
     * @return - returns user.
     */
    public User findByLogin(User user) {
        return this.repository.findByLogin(user.getLogin());
    }

    /**
     * findById - find user by id.
     * @param user - user.
     * @return - returns user.
     */
    public User findById(User user) {
        return this.repository.findById(user.getId()).orElse(null);

    }

    /**
     * updateUser - update user.
     * @param user - user.
     */
    public void updateById(User user) {
        this.save(user);
    }

    /**
     * deleteById - delete by id.
     * @param user - user.
     */
    public void deleteById(User user) {
        this.repository.deleteById(user.getId());
    }

    /**
     * findAll - returns all users.
     * @return - returns all users.
     */
    public List<User> findAll() {
        return this.repository.findAll();
    }

}