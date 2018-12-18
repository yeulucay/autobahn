package com.bahcesehir.autobahn.services.Impl;

import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.ProjectRepository;
import com.bahcesehir.autobahn.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService
{
    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
}
