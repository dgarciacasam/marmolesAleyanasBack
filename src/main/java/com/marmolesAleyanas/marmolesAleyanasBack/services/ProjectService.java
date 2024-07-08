package com.marmolesAleyanas.marmolesAleyanasBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marmolesAleyanas.marmolesAleyanasBack.models.ProjectModel;
import com.marmolesAleyanas.marmolesAleyanasBack.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<ProjectModel> getAll(){
        return projectRepository.findAllByOrderByDateAsc();    
    }
}
