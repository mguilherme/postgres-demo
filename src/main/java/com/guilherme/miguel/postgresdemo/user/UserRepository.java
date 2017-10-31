package com.guilherme.miguel.postgresdemo.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Miguel Guilherme
 */
public interface UserRepository extends CrudRepository<User, String>, UserRepositoryCustom {

    @Query(value = "SELECT * FROM users WHERE info->>'age' < :age", nativeQuery = true)
    List<User> findByAgeLessThan(@Param("age") String age);

    // Param has to be String
    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    List<User> userByName(@Param("name") String name);

}
