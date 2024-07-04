package com.marmolesAleyanas.marmolesAleyanasBack.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmolesAleyanas.marmolesAleyanasBack.models.AuthResponseModel;
import com.marmolesAleyanas.marmolesAleyanasBack.models.LoginRequestModel;
import com.marmolesAleyanas.marmolesAleyanasBack.models.RegisterRequestModel;
import com.marmolesAleyanas.marmolesAleyanasBack.models.RoleModel;
import com.marmolesAleyanas.marmolesAleyanasBack.models.UserModel;
import com.marmolesAleyanas.marmolesAleyanasBack.repository.RoleRepository;
import com.marmolesAleyanas.marmolesAleyanasBack.repository.UserRepository;
import com.marmolesAleyanas.marmolesAleyanasBack.security.JWTGenerator;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTGenerator jwtGenerator;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody LoginRequestModel loginRequest){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), 
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        AuthResponseModel authResponse = new AuthResponseModel(token);
        authResponse.setUsername(loginRequest.getUsername());
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequestModel registerRequest){
        if(userRepository.existsByUsername(registerRequest.getUsername())){
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        UserModel user = new UserModel();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        RoleModel roles = roleRepository.findByName("User").get();
        user.setRoles(Collections.singletonList(roles));
        userRepository.save(user);
        return new ResponseEntity<>("El usuario se ha creado con éxito", HttpStatus.CREATED);
    }
}

