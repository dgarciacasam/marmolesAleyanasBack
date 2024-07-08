package com.marmolesAleyanas.marmolesAleyanasBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmolesAleyanas.marmolesAleyanasBack.models.ProjectModel;
import com.marmolesAleyanas.marmolesAleyanasBack.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping()
    public List<ProjectModel> getAllProjects(){
        return projectService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Integer id){
        Boolean deleted = projectService.deleteById(id);
        if(deleted){
            return ResponseEntity.ok(deleted);
        }
        return ResponseEntity.badRequest().body(deleted);
        
    }
}
