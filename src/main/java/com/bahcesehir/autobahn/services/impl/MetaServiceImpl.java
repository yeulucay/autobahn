package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.views.EnrichmentTableNamesView;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.services.BO.EnrichmentTableListBO;
import com.bahcesehir.autobahn.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MetaServiceImpl implements MetaService {

    private EnrichmentSourceRepository enrichmentSourceRepository;

    @Autowired
    public MetaServiceImpl(EnrichmentSourceRepository enrichmentSourceRepository) {
        this.enrichmentSourceRepository = enrichmentSourceRepository;
    }

    @Override
    public EnrichmentTableNamesView getEnrichmentTableNames(Long enrichmentSourceId) {
        EnrichmentTableListBO bo = new EnrichmentTableListBO(enrichmentSourceId, enrichmentSourceRepository);
        return bo.execute();
    }
}
