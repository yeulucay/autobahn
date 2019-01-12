package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EnrichmentView;
import com.bahcesehir.autobahn.entities.Enrichment;
import com.bahcesehir.autobahn.repositories.EnrichmentRepository;

public class EnrichmentByIdBO implements BaseBO<EnrichmentView> {

    private EnrichmentRepository enrichmentRepository;
    private Long enrichmentId;

    public EnrichmentByIdBO(Long enrichmentId, EnrichmentRepository enrichmentRepository) {
        this.enrichmentRepository = enrichmentRepository;
        this.enrichmentId = enrichmentId;
    }

    @Override
    public EnrichmentView execute() {
        Enrichment enrichment = enrichmentRepository.findById(enrichmentId).orElse(null);
        return new EnrichmentView(enrichment);
    }

    @Override
    public void validate() {

    }
}
