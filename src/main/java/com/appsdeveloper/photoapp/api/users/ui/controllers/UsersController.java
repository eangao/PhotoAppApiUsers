package com.appsdeveloper.photoapp.api.users.ui.controllers;

import com.appsdeveloper.photoapp.api.users.service.UsersService;
import com.appsdeveloper.photoapp.api.users.shared.UserDto;
import com.appsdeveloper.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.appsdeveloper.photoapp.api.users.ui.model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment environment;

    @Autowired
    UsersService usersService;

    @GetMapping("/status/check")
    public String status(){
        return "working on port " + environment.getProperty("local.server.port")
                + "\nToken Expiration Time: " + environment.getProperty("token.expiration_time")
                + "\nToken secret: " + environment.getProperty("token.secret");
    }

    @PostMapping
            (
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails){

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);

        UserDto createdUser = usersService.createUser(userDto);

        CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }
}