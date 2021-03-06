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
     * findUserById - finds user by id and returns user.
     * @param user - user.
     * @return - returns user by id.
     */
    public User findUserById(User user) {
        return this.userRepository.findById(user.getId()).orElse(null);
    }

    /**
     * updateUser - update user by id.
     * @param user - user.
     * @return - returns updated user.
     */
    public User updateUser(User user) {
        User userDB = this.findUserById(user);
        if (userDB != null) {
            if (user.getFirstName() != null) userDB.setFirstName(user.getFirstName());
            if (user.getSecondName() != null) userDB.setSecondName(user.getSecondName());
            this.saveUser(userDB);
        }
        return userDB;
    }

    /**
     * deleteUserById - delete user by id.
     * @param user - user.
     * @return - returns deleted user.
     */
    public User deleteUser(User user) {
        User userDB = this.findUserById(user);
        if (userDB != null) this.userRepository.deleteById(user.getId());
        return userDB;
    }

    /**
     * findAllUser - finds and returns list user.
     * @return - returns list user.
     */
    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

}