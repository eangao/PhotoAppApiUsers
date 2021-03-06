package com.appsdeveloper.photoapp.api.users.shared;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    @Getter(value= AccessLevel.NONE)
    @Setter(value= AccessLevel.NONE)
    private static final long serialVersionUID = 498123263882578413L;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userId;
    private String encryptedPassword;
}
