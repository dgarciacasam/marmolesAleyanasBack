package com.marmolesAleyanas.marmolesAleyanasBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marmolesAleyanas.marmolesAleyanasBack.dto.ProjectDTO;
import com.marmolesAleyanas.marmolesAleyanasBack.dto.mapper.ProjectMapper;
import com.marmolesAleyanas.marmolesAleyanasBack.exceptions.ResourceNotFoundException;
import com.marmolesAleyanas.marmolesAleyanasBack.models.ProjectModel;
import com.marmolesAleyanas.marmolesAleyanasBack.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    public List<ProjectModel> getAll(){
        List<ProjectModel> projects = projectRepository.findAllByOrderByDateAsc();    
        return projects;
    }

    public ProjectModel createProject(ProjectDTO project){
        ProjectModel newProject = new ProjectModel();
        newProject.setDninif(project.getDninif());
        newProject.setName(project.getName());
        newProject.setAddress(project.getAddress());
        newProject.setEmail(project.getEmail());
        newProject.setFinishDate(project.getFinishDate());
        newProject.setPhone(project.getPhone());
        newProject.setAltphone(project.getAltphone());

        ProjectModel createdProject = projectRepository.save(newProject); 
        return createdProject;
    }

    public ProjectModel updateProject(ProjectDTO project, Integer id){
        ProjectModel bdProject = projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El proyecto no se ha encontrado"));
        ProjectMapper.INSTANCE.updateProjectFromDto(project, bdProject);

        projectRepository.save(bdProject);
        return bdProject;
    }
    
    public boolean deleteById(Integer id) {
        try {
            Optional<ProjectModel> entity = projectRepository.findById(id);
            if (entity.isPresent()) {
                projectRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false; 
        }
    }

}
