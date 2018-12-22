package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceTypeView;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceTypeRepository;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceTypeListBO;
import com.bahcesehir.autobahn.services.EnrichmentSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrichmentSourceServiceImpl implements EnrichmentSourceService {

    private EnrichmentSourceTypeRepository enrichmentSourceTypeRepository;

    @Autowired
    public EnrichmentSourceServiceImpl(EnrichmentSourceTypeRepository enrichmentSourceTypeRepository) {
        this.enrichmentSourceTypeRepository = enrichmentSourceTypeRepository;
    }

    @Override
    public Iterable<EnrichmentSourceTypeView> getEnrichmentSourceTypes() {

        EnrichmentSourceTypeListBO bo = new EnrichmentSourceTypeListBO(enrichmentSourceTypeRepository);
        return bo.execute();
    }
}
