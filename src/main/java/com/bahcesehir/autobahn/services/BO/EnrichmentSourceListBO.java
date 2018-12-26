package com.bahcesehir.autobahn.services.BO;


import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.entities.EnrichmentSource;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EnrichmentSourceListBO implements BaseBO<Iterable<EnrichmentSourceView>> {

    private Long endpointId;
    private EnrichmentSourceRepository respository;

    public EnrichmentSourceListBO(Long endpointId, EnrichmentSourceRepository respository) {
        this.endpointId = endpointId;
        this.respository = respository;
    }

    @Override
    public Iterable<EnrichmentSourceView> execute() {
        Iterable<EnrichmentSource> result = respository.getAllByProject(this.endpointId);
        return StreamSupport.stream(result.spliterator(), false)
                .map(EnrichmentSourceView::new).collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
