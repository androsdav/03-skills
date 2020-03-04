package com.adidyk.service;

import com.adidyk.model.Role;
import com.adidyk.model.User;
import com.adidyk.repository.RoleRepository;
import com.adidyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Class UserService.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@Service
public class UserService implements UserDetailsService {

    /**
     * @param userRepository - user repository.
     */
    private UserRepository userRepository;

    /**
     * @param roleRepository - repository.
     */
    private RoleRepository roleRepository;

    /**
     * UserService - constructor.
     * @param repository - repository.
     */
    @Autowired
    UserService(UserRepository repository, RoleRepository roleRepository) {
        this.userRepository = repository;
        this.roleRepository = roleRepository;
    }

    /**
     * loadUserByUsername - loads user by user name.
     * @param login - user login.
     * @return - returns user details
     * @throws UsernameNotFoundException - user not found exception.
     */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = this.userRepository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }

    /**
     * saveUser - adds user.
     * @param user - user.
     */
    public boolean saveUser(User user) {
        User userDB = this.userRepository.findByLogin(user.getLogin());
        if (userDB != null) {
            return false;
        }
        List<Role> roles = new ArrayList<>();
        roles.add(this.roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);
        //user.setRoles(Collections.singleton(this.roleRepository.findByName("ROLE_USER")));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
        return true;
    }

    /**
     * findUserById - find user by id.
     * @param user - user.
     * @return - returns user.
     */
    public User findUserById(User user) {
        return this.userRepository.findById(user.getId()).orElse(null);
    }

    /**
     * deleteUserById - delete by id.
     * @param user - user.
     */
    public boolean deleteUserById(User user) {
        if (this.userRepository.findById(user.getId()).isPresent()) {
            this.userRepository.deleteById(user.getId());
            return true;
        }
        return false;
    }

    /**
     * findAllUser - returns all users.
     * @return - returns all users.
     */
    public List<User> findAllUser() {
        return this.userRepository.findAll();
    }

}