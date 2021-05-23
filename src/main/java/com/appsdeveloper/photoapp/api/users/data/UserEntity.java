package com.appsdeveloper.photoapp.api.users.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Setter
@Getter
@Entity(name = "users")
public class UserEntity implements Serializable {

    @Getter(value=AccessLevel.NONE)
    @Setter(value= AccessLevel.NONE)
    private static final long serialVersionUID = 6947719019596858974L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 120, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private String encryptedPassword;
}
