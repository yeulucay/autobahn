package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EnrichmentContentView;
import com.bahcesehir.autobahn.entities.Enrichment;
import com.bahcesehir.autobahn.repositories.EnrichmentRepository;

public class EnrichmentByIdBO implements BaseBO<EnrichmentContentView> {

    private EnrichmentRepository enrichmentRepository;
    private Long enrichmentId;

    public EnrichmentByIdBO(Long enrichmentId, EnrichmentRepository enrichmentRepository) {
        this.enrichmentRepository = enrichmentRepository;
        this.enrichmentId = enrichmentId;
    }

    @Override
    public EnrichmentContentView execute() {
        Enrichment enrichment = enrichmentRepository.findById(enrichmentId).orElse(null);
        return new EnrichmentContentView(enrichment);
    }

    @Override
    public void validate() {

    }
}
