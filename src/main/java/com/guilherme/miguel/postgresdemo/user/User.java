package com.guilherme.miguel.postgresdemo.user;

import com.guilherme.miguel.postgresdemo.address.Address;
import com.guilherme.miguel.postgresdemo.config.hibernate.types.JSONBUserType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Miguel Guilherme
 */
@Data
@Entity
@Table(name = "users")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
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
    @Column(name = "status")
    private UserStatus userStatus;

    @Type(type = "jsonb")
    @Column(name = "info", columnDefinition = "jsonb")
    private UserInfo userInfo;

}
