package com.bahcesehir.autobahn.services.BO;


import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceTypeView;
import com.bahcesehir.autobahn.entities.EnrichmentSourceType;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceTypeRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EnrichmentSourceTypeListBO implements BaseBO<Iterable<EnrichmentSourceTypeView>>{

    private EnrichmentSourceTypeRepository repository;

    public EnrichmentSourceTypeListBO(EnrichmentSourceTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<EnrichmentSourceTypeView> execute() {
        Iterable<EnrichmentSourceType> result = repository.findAll();

        return StreamSupport.stream(result.spliterator(), false)
                .map(EnrichmentSourceTypeView::new).collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
