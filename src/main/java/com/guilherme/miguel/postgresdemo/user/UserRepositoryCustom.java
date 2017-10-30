package com.guilherme.miguel.postgresdemo.user;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
public interface UserRepositoryCustom {

    List<User> findByAgeGreaterThan(int age);

}
