package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.entities.Project;

import java.util.Optional;


public interface ProjectService {

    public Iterable<Project> getAllProjects();

    public Optional<Project> getProjectById(Long id);
}
