package com.marmolesAleyanas.marmolesAleyanasBack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marmolesAleyanas.marmolesAleyanasBack.models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Integer>{
    Optional<RoleModel> findByName(String name);
}
