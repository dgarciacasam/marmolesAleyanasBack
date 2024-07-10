package com.marmolesAleyanas.marmolesAleyanasBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marmolesAleyanas.marmolesAleyanasBack.models.ProjectDTO;
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

    @PostMapping()
    public ResponseEntity<ProjectModel> createProject(@RequestBody ProjectDTO project){
        ProjectModel savedProject = projectService.createProject(project);
        if(savedProject != null){
            return ResponseEntity.ok(savedProject);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectModel> updateProject(@RequestBody ProjectDTO project, @PathVariable Integer id){
        ProjectModel updatedProject = projectService.updateProject(project, id);
        return ResponseEntity.ok(updatedProject);
    }
}
