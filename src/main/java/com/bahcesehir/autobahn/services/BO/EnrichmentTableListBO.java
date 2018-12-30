package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentTableNamesView;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.services.helpers.JdbcHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class EnrichmentTableListBO implements BaseBO<EnrichmentTableNamesView> {

    private EnrichmentSourceRepository repository;
    private Long enrichmentSourceId;

    public EnrichmentTableListBO(Long enrichmentSourceId, EnrichmentSourceRepository repository) {
        this.enrichmentSourceId = enrichmentSourceId;
        this.repository = repository;
    }

    @Override
    public EnrichmentTableNamesView execute() {
        EnrichmentSourceByIdBO bo = new EnrichmentSourceByIdBO(enrichmentSourceId, repository);
        EnrichmentSourceView enrichmentSource = bo.execute();

        if(!Objects.isNull(enrichmentSource)){
            //TODO: Throw exception
        }

        String jdbcType = JdbcHelper.Instance().getJdbcType(enrichmentSource.getEnrichmentSourceTypeCode());

        String url = JdbcHelper.Instance().getJdbcUrl(jdbcType,
                enrichmentSource.getAddress(),
                enrichmentSource.getPort(),
                enrichmentSource.getDatabaseName());

        try {
            Connection conn = DriverManager.getConnection(url,
                    enrichmentSource.getUsername(),enrichmentSource.getPassword());
            ResultSet rs = conn.getMetaData().getTables(enrichmentSource.getDatabaseName(),
                    "public",
                    "%",
                    null);
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

    @Override
    public void validate() {

    }
}
