package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentTableNamesView;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceByIdBO;
import com.bahcesehir.autobahn.services.BO.EnrichmentTableListBO;
import com.bahcesehir.autobahn.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
