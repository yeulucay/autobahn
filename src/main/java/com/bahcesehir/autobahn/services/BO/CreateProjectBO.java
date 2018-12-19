package com.bahcesehir.autobahn.services.BO;


import com.bahcesehir.autobahn.controllers.dto.CreateProjectDto;
import com.bahcesehir.autobahn.controllers.views.ProjectView;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.ProjectRepository;

import java.time.LocalDateTime;
import java.util.Objects;

public class CreateProjectBO implements BaseBO<ProjectView> {

    private CreateProjectDto dto;
    private ProjectRepository repository;

    public CreateProjectBO(ProjectRepository repository, CreateProjectDto dto){
        this.dto = dto;
        this.repository = repository;
    }

    @Override
    public ProjectView execute() {
        Project p = new Project();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setCreatedAt(LocalDateTime.now());
        p = repository.save(p);

        if(!Objects.isNull(p)){
            return new ProjectView(p);
        }
        return null;
    }
}
