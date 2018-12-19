package com.bahcesehir.autobahn.services.BO;


import com.bahcesehir.autobahn.controllers.views.ProjectView;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.ProjectRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProjectListBO implements BaseBO<Iterable<ProjectView>> {

    private ProjectRepository projectRepository;

    public ProjectListBO(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Iterable<ProjectView> execute() {
        Iterable<Project> projects = projectRepository.findAll();
        return StreamSupport.stream(projects.spliterator(), false)
                .map(ProjectView::new).collect(Collectors.toList());
    }
}
