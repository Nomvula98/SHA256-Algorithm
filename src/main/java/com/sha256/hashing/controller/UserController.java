package com.sha256.hashing.controller;

import com.sha256.hashing.entity.UserDetails;
import com.sha256.hashing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService = new UserService();

    /**
     * End point for user to login
     */
    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password){
        return userService.login(username,password);
    }

    /**
     * End point for user registration
     */
    @PostMapping(value = "/reg")
    public String register(@RequestBody UserDetails userDetails){
        return userService.reg(userDetails);
    }
}
