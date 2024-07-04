package com.marmolesAleyanas.marmolesAleyanasBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marmolesAleyanas.marmolesAleyanasBack.models.UserModel;
import com.marmolesAleyanas.marmolesAleyanasBack.repository.UserRepository;

@Service
public class UserService{
    @Autowired
    private UserRepository userRepository;

    public List<UserModel>findAll(){
        return userRepository.findAll();
    }
}
