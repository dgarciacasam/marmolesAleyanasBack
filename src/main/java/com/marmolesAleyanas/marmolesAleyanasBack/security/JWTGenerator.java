package com.marmolesAleyanas.marmolesAleyanasBack.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {

    public final long JWT_EXPIRATION = 60000 * 60 * 10;
    public String JWTSECRET = "qeofuqhergfouqewhgfuoqefhqouehfgqewpoufghqoefguhqegfuqwehgfeqpwufhqwpeufghegpuqehfpquohfeouhqo";

    public String generateToken(Authentication auth){
        String username = auth.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + JWT_EXPIRATION);

        String token = Jwts.builder()
            .subject(username)
            .issuedAt(currentDate)
            .expiration(expireDate)
            .signWith(getSigningKey())
            .compact();
        return token;
    }

        public String getSubjectFromToken(String token) {
        Claims claims = Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();

        return claims.getSubject();
      }
    
      public boolean validateToken(String token) {
        try {
          Jwts.parser()
            .verifyWith(getSigningKey())
            .build()
            .parseSignedClaims(token);
          return true;
        } catch (Exception e) {
          throw new AuthenticationCredentialsNotFoundException("El token ha expirado");
        }
      }

    public SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWTSECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}