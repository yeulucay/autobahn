package com.bahcesehir.autobahn.controllers;

import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.services.Impl.ProjectServiceImpl;
import com.bahcesehir.autobahn.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService){
        this.projectService = projectService;
    }

    @GetMapping("all")
    public ResponseEntity<Iterable<Project>> getAllProjects(){
        Iterable<Project> result = projectService.getAllProjects();
        return new ResponseEntity<Iterable<Project>>(result, HttpStatus.OK);
    }

}