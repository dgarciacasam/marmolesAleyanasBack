package com.marmolesAleyanas.marmolesAleyanasBack.services;

import java.util.List;
import java.util.Optional;

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

    public boolean deleteById(Integer id) {
        try {
            Optional<ProjectModel> entity = projectRepository.findById(id);
            if (entity.isPresent()) {
                projectRepository.deleteById(id);
                return true;
            } else {
                return false; // No se encontró la entidad
            }
        } catch (Exception e) {
            return false; // Ocurrió un error al intentar eliminar la entidad
        }
    }

}
