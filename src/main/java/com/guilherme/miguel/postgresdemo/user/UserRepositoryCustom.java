package com.guilherme.miguel.postgresdemo.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
public interface UserRepositoryCustom {

    List<User> findByAgeGreaterThan(int age);

}
