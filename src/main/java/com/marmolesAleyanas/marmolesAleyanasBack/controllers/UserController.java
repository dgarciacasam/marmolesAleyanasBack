package com.marmolesAleyanas.marmolesAleyanasBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmolesAleyanas.marmolesAleyanasBack.models.UserModel;
import com.marmolesAleyanas.marmolesAleyanasBack.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserModel> GetAllUsers(){
        return userService.findAll();

    }
}
