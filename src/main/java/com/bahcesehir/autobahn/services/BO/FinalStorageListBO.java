package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.FinalStorageView;
import com.bahcesehir.autobahn.entities.FinalStorage;
import com.bahcesehir.autobahn.repositories.FinalStorageRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class FinalStorageListBO implements BaseBO<Iterable<FinalStorageView>> {

    private FinalStorageRepository finalStorageRepository;
    private Long projectId;

    public FinalStorageListBO(Long projectId, FinalStorageRepository finalStorageRepository) {
        this.finalStorageRepository = finalStorageRepository;
        this.projectId = projectId;
    }

    @Override
    public Iterable<FinalStorageView> execute() {
        Iterable<FinalStorage> result = finalStorageRepository.findAllByProjectId(this.projectId);

        return StreamSupport.stream(result.spliterator(), false)
                .map(FinalStorageView::new).collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
