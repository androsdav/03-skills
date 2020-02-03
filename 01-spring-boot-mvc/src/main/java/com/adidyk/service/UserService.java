package com.adidyk.service;

import com.adidyk.model.User;
import com.adidyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void save(User user) {
        this.repository.save(user);
    }

}