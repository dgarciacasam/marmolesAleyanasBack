package com.marmolesAleyanas.marmolesAleyanasBack.models;

import lombok.Data;

@Data
public class AuthResponseModel {
    private String accesToken;
    private String tokenType = "Bearer ";
    private String username;
    public AuthResponseModel(String token){
        accesToken = token;
    }
}
