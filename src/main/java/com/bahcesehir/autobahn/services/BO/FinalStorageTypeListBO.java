package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.FinalStorageTypeView;
import com.bahcesehir.autobahn.entities.FinalStorageType;
import com.bahcesehir.autobahn.repositories.FinalStorageTypeRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class FinalStorageTypeListBO implements BaseBO<Iterable<FinalStorageTypeView>> {

    private FinalStorageTypeRepository repository;

    public FinalStorageTypeListBO(FinalStorageTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<FinalStorageTypeView> execute() {
        Iterable<FinalStorageType> result = repository.findAll();
        return StreamSupport.stream(result.spliterator(), false)
                .map(FinalStorageTypeView::new).collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
