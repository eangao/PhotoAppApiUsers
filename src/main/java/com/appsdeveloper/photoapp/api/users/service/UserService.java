package com.appsdeveloper.photoapp.api.users.service;

import com.appsdeveloper.photoapp.api.users.shared.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDetails);
}
