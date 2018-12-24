package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.dto.ProjectCreateDto;
import com.bahcesehir.autobahn.controllers.views.ProjectView;

import java.util.Optional;


public interface ProjectService {

    public Iterable getAllProjects();

    public Optional getProjectById(Long id);

    public ProjectView createProject(ProjectCreateDto project);
}
