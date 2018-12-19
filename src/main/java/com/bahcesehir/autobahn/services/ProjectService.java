package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.dto.CreateProjectDto;
import com.bahcesehir.autobahn.controllers.views.ProjectView;
import com.bahcesehir.autobahn.entities.Project;

import java.util.Optional;


public interface ProjectService {

    public Iterable getAllProjects();

    public Optional getProjectById(Long id);

    public ProjectView createProject(CreateProjectDto project);
}
