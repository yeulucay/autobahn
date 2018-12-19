package com.bahcesehir.autobahn.controllers;

import com.bahcesehir.autobahn.controllers.dto.CreateProjectDto;
import com.bahcesehir.autobahn.controllers.views.ProjectView;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.services.impl.ProjectServiceImpl;
import com.bahcesehir.autobahn.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectServiceImpl projectService){
        this.projectService = projectService;
    }

    /**
     * Get all project list
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Iterable> getAllProjects(){
        Iterable result = projectService.getAllProjects();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Create new project
     */
    @PostMapping("/create")
    public ResponseEntity<ProjectView> createProject(@RequestBody CreateProjectDto project){
        ProjectView result = projectService.createProject(project);
        return new ResponseEntity<>(result, result != null ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }
}
