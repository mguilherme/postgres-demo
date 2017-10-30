package com.guilherme.miguel.postgresdemo.user;

import com.guilherme.miguel.postgresdemo.address.Address;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Miguel Guilherme
 */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @ManyToOne
    @NotNull
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

}
