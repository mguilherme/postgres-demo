package com.guilherme.miguel.postgresdemo.user.impl;

import com.guilherme.miguel.postgresdemo.user.User;
import com.guilherme.miguel.postgresdemo.user.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Miguel Guilherme
 */
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public List<User> findByAgeGreaterThan(int age) {

        List<User> users = entityManager.createNativeQuery("SELECT * FROM users WHERE info->>'age' >= :age", User.class)
                .setParameter("age", String.valueOf(age))
                .getResultList();

        return users;
    }

//        entityManager.find(User.class, "66954283-08e6-46f7-a4fc-790bdbe48ec5").getUserInfo();
//        entityManager.createQuery("from User", User.class).getResultList()
//        entityManager.createQuery("from User where  userStatus = :status", User.class).setParameter("status", UserStatus.ACTIVE).getResultList();
//        entityManager.createNativeQuery("SELECT * FROM users WHERE name = 'John'", User.class).getResultList();
//        entityManager.createNativeQuery("SELECT * FROM users WHERE info->>'ttl' > :ttl", User.class).setParameter("ttl", "2") .getResultList();
//        entityManager.createNativeQuery("SELECT * FROM users WHERE info->>'age' >= :age", User.class).setParameter("age", "25") .getResultList();
//        SELECT * FROM merchants m WHERE m.profile -> 'company' ->> 'name' ilike '%XPTO%';    

}
