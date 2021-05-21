package com.appsdeveloper.photoapp.api.users.ui.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequestModel {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
