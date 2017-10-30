package com.guilherme.miguel.postgresdemo;

import com.guilherme.miguel.postgresdemo.address.Address;
import com.guilherme.miguel.postgresdemo.address.AddressRepository;
import com.guilherme.miguel.postgresdemo.user.*;
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

            //Info
            UserInfo userInfo1 = new UserInfo();
            userInfo1.setTtl(3);
            userInfo1.setNotes("This is a test note");
            userInfo1.setLuckyNumbers(Stream.of(3, 5, 6).collect(Collectors.toList()));
            userInfo1.setAdditionalInfo(new AdditionalInfo("My additional info."));

            // Users
            User user1 = new User();
            user1.setName("John");
            user1.setEmail("John@my-mail.com");
            user1.setUserStatus(UserStatus.ACTIVE);
            user1.setAddress(address1);
            user1.setUserInfo(userInfo1);

            User user2 = new User();
            user2.setName("Peter");
            user2.setEmail("peter@my-mail.com");
            user2.setUserStatus(UserStatus.ACTIVE);
            user2.setAddress(address1);
            user2.setUserInfo(userInfo1);

            User user3 = new User();
            user3.setName("Mary");
            user3.setEmail("mary@my-mail.com");
            user3.setUserStatus(UserStatus.INACTIVE);
            user3.setAddress(address2);
            user3.setUserInfo(userInfo1);

            userRepository.save(Stream.of(user1, user2, user3).collect(Collectors.toList()));

            userRepository.findAll().forEach(System.out::println);


        };
    }
}
