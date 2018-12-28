package com.bahcesehir.autobahn.controllers;


import com.bahcesehir.autobahn.controllers.dto.EnrichmentSourceCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentColumnNamesView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentTableNamesView;
import com.bahcesehir.autobahn.entities.EnrichmentSource;
import com.bahcesehir.autobahn.services.EnrichmentSourceService;
import com.bahcesehir.autobahn.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/enrichmentsource")
public class EnrichmentSourceController {

    private EnrichmentSourceService enrichmentSourceService;
    private MetaService metaService;

    @Autowired
    public EnrichmentSourceController(EnrichmentSourceService enrichmentSourceService,
                                      MetaService metaService) {
        this.enrichmentSourceService = enrichmentSourceService;
        this.metaService = metaService;
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
    @GetMapping("/list/{projectId}")
    public ResponseEntity<Iterable> getEnrichmentSources(@PathVariable Long projectId){
        Iterable result = enrichmentSourceService.getEnrichmentSources(projectId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get table names from enrichment source
     * @param enrichmentSourceId
     * @return
     */
    @GetMapping("/table/list/{enrichmentSourceId}")
    public ResponseEntity<EnrichmentTableNamesView> getEnrichmentTables(@PathVariable Long enrichmentSourceId){
        EnrichmentTableNamesView result = metaService.getEnrichmentTableNames(enrichmentSourceId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get column names from enrichment source
     * @param enrichmentSourceId
     * @param columnName
     * @return
     */
    @GetMapping("/column/list/{enrichmentSourceId}/{columnName}")
    public ResponseEntity<EnrichmentColumnNamesView> getEnrichmentColumns(
            @PathVariable Long enrichmentSourceId,
            @PathVariable String columnName){
        EnrichmentColumnNamesView result = metaService.getEnrichmentColumnNames(enrichmentSourceId, columnName);
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
