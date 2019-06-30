package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.dto.EnrichmentCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentContentView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentView;
import com.bahcesehir.autobahn.repositories.EnrichmentRepository;
import com.bahcesehir.autobahn.services.BO.EnrichmentByIdBO;
import com.bahcesehir.autobahn.services.BO.EnrichmentCreateBO;
import com.bahcesehir.autobahn.services.BO.EnrichmentListBO;
import com.bahcesehir.autobahn.services.EnrichmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnrichmentServiceImpl implements EnrichmentService {

    private EnrichmentRepository enrichmentRepository;
    private EnrichmentCreateBO enrichmentCreateBO;

    @Autowired
    public EnrichmentServiceImpl(EnrichmentRepository enrichmentRepository,
                                 EnrichmentCreateBO enrichmentCreateBO) {
        this.enrichmentRepository = enrichmentRepository;
        this.enrichmentCreateBO = enrichmentCreateBO;
    }

    @Override
    public EnrichmentContentView getEnrichmentById(Long enrichmentId){
        EnrichmentByIdBO bo = new EnrichmentByIdBO(enrichmentId, enrichmentRepository);
        return bo.execute();
    }

    @Override
    public List<EnrichmentView> getEnrichmentByProjectId(Long projectId) {
        EnrichmentListBO bo = new EnrichmentListBO(projectId, enrichmentRepository);
        return bo.execute();
    }

    @Override
    public EnrichmentContentView createEnrichment(EnrichmentCreateDto dto) {
        enrichmentCreateBO.setDto(dto);
        return enrichmentCreateBO.execute();
    }
}
