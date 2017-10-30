package com.guilherme.miguel.postgresdemo.user;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Miguel Guilherme
 */
public interface UserRepository extends CrudRepository<User, String> {
}
