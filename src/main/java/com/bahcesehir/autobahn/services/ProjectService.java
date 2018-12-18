package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.entities.Project;
import org.springframework.stereotype.Service;


public interface ProjectService {

    public Iterable<Project> getAllProjects();

    public Project getProjectById(Long id);
}
