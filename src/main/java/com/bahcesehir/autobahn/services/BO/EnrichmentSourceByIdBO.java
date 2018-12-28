package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.entities.EnrichmentSource;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;

import java.util.Objects;


public class EnrichmentSourceByIdBO implements BaseBO<EnrichmentSourceView> {

    private Long enrichmentSourceId;
    private EnrichmentSourceRepository repository;

    public EnrichmentSourceByIdBO(Long enrichmentSourceId, EnrichmentSourceRepository repository) {
        this.enrichmentSourceId = enrichmentSourceId;
        this.repository = repository;
    }

    @Override
    public EnrichmentSourceView execute() {
        EnrichmentSource result = repository.findById(enrichmentSourceId).orElse(null);
        return new EnrichmentSourceView(result);
    }

    @Override
    public void validate() {

    }
}
