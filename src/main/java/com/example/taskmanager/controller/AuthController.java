package com.example.taskmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @GetMapping("/user")
    public String getUser(){
        return "User information";
    }

    @PostMapping("/login")
    public String login(){
        return "User logged in";
    }

    @PostMapping("/logout")
    public String logout(){
        return "User logged out";
    }
}
