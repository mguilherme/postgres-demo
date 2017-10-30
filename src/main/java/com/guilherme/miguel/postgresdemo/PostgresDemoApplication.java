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
            userInfo1.setTtl(2);
            userInfo1.setNotes("This is a test note");
            userInfo1.setLuckyNumbers(Stream.of(3, 5, 6).collect(Collectors.toList()));
            userInfo1.setAdditionalInfo(new AdditionalInfo("My additional info."));
            userInfo1.setAge(20);

            UserInfo userInfo2 = new UserInfo();
            userInfo2.setTtl(1);
            userInfo2.setNotes("This is a big note");
            userInfo2.setLuckyNumbers(Stream.of(5, 10, 9, 4).collect(Collectors.toList()));
            userInfo2.setAdditionalInfo(new AdditionalInfo("more info."));
            userInfo2.setAge(25);

            UserInfo userInfo3 = new UserInfo();
            userInfo3.setTtl(4);
            userInfo3.setNotes("This is another test note");
            userInfo3.setLuckyNumbers(Stream.of(76, 7, 1).collect(Collectors.toList()));
            userInfo3.setAdditionalInfo(new AdditionalInfo("hidden info."));
            userInfo3.setAge(30);

            UserInfo userInfo4 = new UserInfo();
            userInfo4.setTtl(5);
            userInfo4.setNotes("More notes");
            userInfo4.setLuckyNumbers(Stream.of(22, 1, 34, 76).collect(Collectors.toList()));
            userInfo4.setAdditionalInfo(new AdditionalInfo("such info."));
            userInfo4.setAge(32);

            // Users
            User user1 = new User();
            user1.setName("John");
            user1.setEmail("John@my-mail.com");
            user1.setUserStatus(UserStatus.ACTIVE);
            user1.setAddress(address1);
            user1.setUserInfo(userInfo2);

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
            user3.setUserInfo(userInfo3);

            User user4 = new User();
            user4.setName("Kate");
            user4.setEmail("kate@my-mail.com");
            user4.setUserStatus(UserStatus.INACTIVE);
            user4.setAddress(address1);
            user4.setUserInfo(userInfo4);

            userRepository.save(Stream.of(user1, user2, user3).collect(Collectors.toList()));

            userRepository.findAll().forEach(System.out::println);

            userRepository.findByAgeGreaterThan(25).forEach(System.out::println);

        };
    }
}
