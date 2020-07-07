package com.adidyk.service;

import com.adidyk.model.User;
import com.adidyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class UserService.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@Service
public class UserService {

    /**
     * @param userRepository - user repository.
     */
    private UserRepository userRepository;

    /**
     * UserService - constructor.
     * @param userRepository - user repository.
     */
    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * saveUser - save user.
     * @param user - user.
     */
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    /**
     * findAllUser - finds and returns list user.
     * @return - returns list user.
     */
    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

}