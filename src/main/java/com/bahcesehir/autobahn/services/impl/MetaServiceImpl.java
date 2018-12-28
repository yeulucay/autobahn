package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentTableNamesView;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.services.BO.EnrichmentSourceByIdBO;
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
        EnrichmentSourceByIdBO bo = new EnrichmentSourceByIdBO(enrichmentSourceId, enrichmentSourceRepository);
        EnrichmentSourceView enrichmentSource = bo.execute();

        if(!Objects.isNull(enrichmentSource)){
            //TODO: Throw exception
        }

        String jdbcType = "";
        switch (enrichmentSource.getEnrichmentSourceTypeCode()){
            case "MYSQL":
                jdbcType = "mysql";
                break;
            case "POSTGRESQL":
                jdbcType = "postgresql";
                break;
        }

        String url = String.format("jdbc:%s://%s:%s/%s",
                jdbcType,
                enrichmentSource.getAddress(),
                enrichmentSource.getPort(),
                enrichmentSource.getDatabaseName());

        try {
            Connection conn = DriverManager.getConnection(url,
                    enrichmentSource.getUsername(),enrichmentSource.getPassword());
            ResultSet rs = conn.getMetaData()
                    .getTables(enrichmentSource.getDatabaseName(), "public", "%", null);
            List<String> results = new ArrayList<>();
            while(rs.next()){
                if(rs.getString(4).equals("TABLE")) {
                    results.add(rs.getString(3));
                }
            }
            return new EnrichmentTableNamesView(results);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
