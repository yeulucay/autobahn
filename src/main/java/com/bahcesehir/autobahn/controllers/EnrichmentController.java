package com.bahcesehir.autobahn.controllers;


import com.bahcesehir.autobahn.services.EnrichmentSourceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enrichment")
public class EnrichmentController {

    private EnrichmentSourceService enrichmentSourceService;

    public EnrichmentController(EnrichmentSourceService enrichmentSourceService) {
        this.enrichmentSourceService = enrichmentSourceService;
    }

    /**
     * Get enrichment source types.
     * @return
     */
    @GetMapping("sourcetypes")
    public ResponseEntity<Iterable> getEnrichmentSourceTypes(){

        Iterable result = enrichmentSourceService.getEnrichmentSourceTypes();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
