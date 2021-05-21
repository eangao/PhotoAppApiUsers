package com.appsdeveloper.photoapp.api.users.ui.controllers;

import com.appsdeveloper.photoapp.api.users.ui.model.CreateUserRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment environment;

    @GetMapping("/status/check")
    public String status(){
        return "working on port " + environment.getProperty("local.server.port");
    }

    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails){
        return "Create user method is called";
    }
}