package com.appsdeveloper.photoapp.api.users.service;

import com.appsdeveloper.photoapp.api.users.shared.UserDto;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public UserDto createUser(UserDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        return null;
    }
}
