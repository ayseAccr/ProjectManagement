package com.ex.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ex.demo.Model.Project;
import com.ex.demo.Repository.ProjectRepository;
@Service
public class ProjectService {
    

     ProjectRepository projectRepo;

    // public Project getOneProject(Long projectId) {

    //     return projectRepo.findById(projectId).orElse(null);
    // }

    // public List<Project> searchProject(String keyword){
    //     if(keyword != null){
    //         return projectRepo.searchProject(keyword);
    //     }
    //     return (List<Project>)projectRepo.findAll();
    // }

}
