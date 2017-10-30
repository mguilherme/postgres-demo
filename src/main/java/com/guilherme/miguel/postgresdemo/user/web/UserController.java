package com.guilherme.miguel.postgresdemo.user.web;

import com.guilherme.miguel.postgresdemo.user.User;
import com.guilherme.miguel.postgresdemo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miguel Guilherme
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public Iterable<User> users() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User user(@PathVariable("id") String id) {
        return userRepository.findOne(id);
    }

}
