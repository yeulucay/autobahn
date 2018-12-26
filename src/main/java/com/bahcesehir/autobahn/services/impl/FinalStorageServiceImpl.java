package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.views.FinalStorageTypeView;
import com.bahcesehir.autobahn.repositories.FinalStorageTypeRepository;
import com.bahcesehir.autobahn.services.BO.FinalStorageTypeListBO;
import com.bahcesehir.autobahn.services.FinalStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FinalStorageServiceImpl implements FinalStorageService {

    private FinalStorageTypeRepository finalStorageTypeRepository;

    @Autowired
    public FinalStorageServiceImpl(FinalStorageTypeRepository finalStorageTypeRepository) {
        this.finalStorageTypeRepository = finalStorageTypeRepository;
    }

    @Override
    public Iterable<FinalStorageTypeView> getFinalStorageTypes() {
        FinalStorageTypeListBO bo = new FinalStorageTypeListBO(finalStorageTypeRepository);
        return bo.execute();
    }
}
