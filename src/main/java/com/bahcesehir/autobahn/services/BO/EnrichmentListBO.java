package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EnrichmentContentView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentView;
import com.bahcesehir.autobahn.entities.Enrichment;
import com.bahcesehir.autobahn.repositories.EnrichmentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EnrichmentListBO implements BaseBO<List<EnrichmentView>> {

    private EnrichmentRepository enrichmentRepository;
    private Long projectId;

    public EnrichmentListBO(Long projectId, EnrichmentRepository enrichmentRepository) {
        this.enrichmentRepository = enrichmentRepository;
        this.projectId = projectId;
    }

    @Override
    public List<EnrichmentView> execute() {
        List<Enrichment> enrichmentList = enrichmentRepository.findAllByProjectId(projectId);
        return StreamSupport.stream(enrichmentList.spliterator(),false)
                .map(EnrichmentView::new).collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
