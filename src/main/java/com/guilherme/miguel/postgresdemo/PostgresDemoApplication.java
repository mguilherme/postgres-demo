package com.guilherme.miguel.postgresdemo;

import com.guilherme.miguel.postgresdemo.address.Address;
import com.guilherme.miguel.postgresdemo.address.AddressRepository;
import com.guilherme.miguel.postgresdemo.user.Status;
import com.guilherme.miguel.postgresdemo.user.User;
import com.guilherme.miguel.postgresdemo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class PostgresDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, AddressRepository addressRepository) {
        return strings -> {

            // Addresses
            Address address1 = new Address();
            address1.setCity("Lisbon");

            Address address2 = new Address();
            address2.setCity("Manchester");

            addressRepository.save(Stream.of(address1, address2).collect(Collectors.toList()));

            // Users
            User user1 = new User();
            user1.setName("John");
            user1.setEmail("John@my-mail.com");
            user1.setStatus(Status.ACTIVE);
            user1.setAddress(address1);

            User user2 = new User();
            user2.setName("Peter");
            user2.setEmail("peter@my-mail.com");
            user2.setStatus(Status.ACTIVE);
            user2.setAddress(address1);

            User user3 = new User();
            user3.setName("Mary");
            user3.setEmail("mary@my-mail.com");
            user3.setStatus(Status.INACTIVE);
            user3.setAddress(address2);

            userRepository.save(Stream.of(user1, user2, user3).collect(Collectors.toList()));

            userRepository.findAll().forEach(System.out::println);


        };
    }
}
