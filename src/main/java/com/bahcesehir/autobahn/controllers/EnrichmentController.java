package com.bahcesehir.autobahn.controllers;

import com.bahcesehir.autobahn.controllers.views.EnrichmentContentView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentView;
import com.bahcesehir.autobahn.services.EnrichmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping(path = "/enrichment")
public class EnrichmentController {

    private EnrichmentService enrichmentService;

    @Autowired
    public EnrichmentController(EnrichmentService enrichmentService) {
        this.enrichmentService = enrichmentService;
    }

    /**
     * Get enrichment by Id
     * @param enrichmentId
     * @return
     */
    @GetMapping("/{enrichmentId}")
    public ResponseEntity getEnrichmentById(@PathVariable Long enrichmentId){
        EnrichmentContentView result = enrichmentService.getEnrichmentById(enrichmentId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get enrichment list by projectId
     * @param projectId
     * @return
     */
    @GetMapping("/list/{projectId}")
    public ResponseEntity<Iterable> getEnrichmentByProject(@PathVariable Long projectId){
        List<EnrichmentView> result = enrichmentService.getEnrichmentByProjectId(projectId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
