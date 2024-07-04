package com.marmolesAleyanas.marmolesAleyanasBack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marmolesAleyanas.marmolesAleyanasBack.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUsername(String username);
    Boolean existsByUsername(String username);
}
