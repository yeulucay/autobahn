package com.bahcesehir.autobahn.controllers;


import com.bahcesehir.autobahn.controllers.dto.EnrichmentSourceCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.entities.EnrichmentSource;
import com.bahcesehir.autobahn.services.EnrichmentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrichmentsource")
public class EnrichmentSourceController {

    private EnrichmentSourceService enrichmentSourceService;

    @Autowired
    public EnrichmentSourceController(EnrichmentSourceService enrichmentSourceService) {
        this.enrichmentSourceService = enrichmentSourceService;
    }

    /**
     * Create enrichment source
     * @param dto
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<EnrichmentSourceView> createEnrichmentSource(@RequestBody EnrichmentSourceCreateDto dto){
        EnrichmentSourceView result = enrichmentSourceService.createEnrichmentSource(dto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Get all enrichment source
     * @return
     */
    @GetMapping("/list/{endpoint}")
    public ResponseEntity<Iterable> getEnrichmentSources(@PathVariable Long endpoint){
        Iterable result = enrichmentSourceService.getEnrichmentSources(endpoint);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get enrichment source types.
     * @return
     */
    @GetMapping("/types/list")
    public ResponseEntity<Iterable> getEnrichmentSourceTypes(){

        Iterable result = enrichmentSourceService.getEnrichmentSourceTypes();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
