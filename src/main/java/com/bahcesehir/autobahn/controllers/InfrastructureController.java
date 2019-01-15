package com.bahcesehir.autobahn.controllers;

import com.bahcesehir.autobahn.services.DockerRunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping(path="/infrastructure")
public class InfrastructureController {

    private DockerRunnerService dockerRunnerService;

    @Autowired
    public InfrastructureController(DockerRunnerService dockerRunnerService) {
        this.dockerRunnerService = dockerRunnerService;
    }

    @GetMapping("/enrichment/run/{enrichmentId}")
    public void runEnrichment(@PathVariable Long enrichmentId){
        dockerRunnerService.createContainer(enrichmentId);
    }
}
