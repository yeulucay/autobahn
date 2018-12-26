package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.dto.EnrichmentSourceCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceTypeView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.EndPointRepository;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceTypeRepository;
import com.bahcesehir.autobahn.repositories.ProjectRepository;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceCreateBO;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceListBO;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceTypeListBO;
import com.bahcesehir.autobahn.services.EnrichmentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrichmentSourceServiceImpl implements EnrichmentSourceService {

    private EnrichmentSourceRepository enrichmentSourceRepository;
    private EnrichmentSourceTypeRepository enrichmentSourceTypeRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public EnrichmentSourceServiceImpl(EnrichmentSourceRepository enrichmentSourceRepository,
                                       EnrichmentSourceTypeRepository enrichmentSourceTypeRepository,
                                       ProjectRepository projectRepository) {
        this.enrichmentSourceRepository = enrichmentSourceRepository;
        this.enrichmentSourceTypeRepository = enrichmentSourceTypeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public EnrichmentSourceView createEnrichmentSource(EnrichmentSourceCreateDto dto) {
        EnrichmentSourceCreateBO bo = new EnrichmentSourceCreateBO(dto, enrichmentSourceRepository,
                enrichmentSourceTypeRepository, projectRepository);
        return bo.execute();
    }

    @Override
    public Iterable<EnrichmentSourceView> getEnrichmentSources(Long endpointId) {
        EnrichmentSourceListBO bo = new EnrichmentSourceListBO(endpointId, enrichmentSourceRepository);
        return bo.execute();
    }

    @Override
    public Iterable<EnrichmentSourceTypeView> getEnrichmentSourceTypes() {

        EnrichmentSourceTypeListBO bo = new EnrichmentSourceTypeListBO(enrichmentSourceTypeRepository);
        return bo.execute();
    }
}
