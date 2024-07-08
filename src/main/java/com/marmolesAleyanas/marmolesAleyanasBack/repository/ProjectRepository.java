package com.marmolesAleyanas.marmolesAleyanasBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marmolesAleyanas.marmolesAleyanasBack.models.ProjectModel;

public interface ProjectRepository extends JpaRepository<ProjectModel, Integer>{
    List<ProjectModel> findAllByOrderByDateAsc();
}

