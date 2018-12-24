package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.dto.EnrichmentSourceCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceTypeView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceTypeRepository;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceCreateBO;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceTypeListBO;
import com.bahcesehir.autobahn.services.EnrichmentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrichmentSourceServiceImpl implements EnrichmentSourceService {

    private EnrichmentSourceRepository enrichmentSourceRepository;
    private EnrichmentSourceTypeRepository enrichmentSourceTypeRepository;

    @Autowired
    public EnrichmentSourceServiceImpl(EnrichmentSourceRepository enrichmentSourceRepository,
                                       EnrichmentSourceTypeRepository enrichmentSourceTypeRepository) {
        this.enrichmentSourceRepository = enrichmentSourceRepository;
        this.enrichmentSourceTypeRepository = enrichmentSourceTypeRepository;
    }

    @Override
    public EnrichmentSourceView createEnrichmentSource(EnrichmentSourceCreateDto dto) {
        EnrichmentSourceCreateBO bo = new EnrichmentSourceCreateBO(dto, enrichmentSourceRepository,
                enrichmentSourceTypeRepository);
        return bo.execute();
    }

    @Override
    public Iterable<EnrichmentSourceTypeView> getEnrichmentSourceTypes() {

        EnrichmentSourceTypeListBO bo = new EnrichmentSourceTypeListBO(enrichmentSourceTypeRepository);
        return bo.execute();
    }
}
