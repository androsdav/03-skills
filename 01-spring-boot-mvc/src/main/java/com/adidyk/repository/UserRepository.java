package com.adidyk.repository;

import com.adidyk.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface UserRepository used for access to data base.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 03.02.2020.
 * @version 1.0.
 */
@Repository
public interface  UserRepository extends CrudRepository<User, Long> {
}