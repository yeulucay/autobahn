package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.dto.CreateProjectDto;
import com.bahcesehir.autobahn.controllers.views.ProjectView;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.ProjectRepository;
import com.bahcesehir.autobahn.services.BO.CreateProjectBO;
import com.bahcesehir.autobahn.services.BO.ProjectListBO;
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
    public Iterable<ProjectView> getAllProjects() {
        ProjectListBO bo = new ProjectListBO(projectRepository);
        return bo.execute();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public ProjectView createProject(CreateProjectDto project) {
        CreateProjectBO bo = new CreateProjectBO(projectRepository, project);
        return bo.execute();
    }
}
