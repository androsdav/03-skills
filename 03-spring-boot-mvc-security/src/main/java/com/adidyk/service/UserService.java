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
     * @param userRepository - user repository.
     * @param roleRepository - role repository.
     */
    @Autowired
    UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * loadUserByUserName - loads user by user name (login user).
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
     * saveUser - adds user with role "ROLE_USER".
     * @param user - user.
     */
    public boolean saveUser(User user) {
        User userDB = this.userRepository.findByLogin(user.getLogin());
        if (userDB != null) {
            return false;
        }
        List<Role> roles = new ArrayList<>() ;
        roles.add(this.roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
        return true;
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