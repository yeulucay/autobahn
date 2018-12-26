package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.dto.FinalStorageCreateDto;
import com.bahcesehir.autobahn.controllers.views.FinalStorageTypeView;
import com.bahcesehir.autobahn.controllers.views.FinalStorageView;
import com.bahcesehir.autobahn.repositories.FinalStorageRepository;
import com.bahcesehir.autobahn.repositories.FinalStorageTypeRepository;
import com.bahcesehir.autobahn.repositories.ProjectRepository;
import com.bahcesehir.autobahn.services.BO.FinalStorageCreateBO;
import com.bahcesehir.autobahn.services.BO.FinalStorageListBO;
import com.bahcesehir.autobahn.services.BO.FinalStorageTypeListBO;
import com.bahcesehir.autobahn.services.FinalStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FinalStorageServiceImpl implements FinalStorageService {

    private FinalStorageTypeRepository finalStorageTypeRepository;
    private FinalStorageRepository finalStorageRepository;
    private ProjectRepository projectRepository;

    public FinalStorageServiceImpl(FinalStorageTypeRepository finalStorageTypeRepository,
                                   FinalStorageRepository finalStorageRepository, ProjectRepository projectRepository) {
        this.finalStorageTypeRepository = finalStorageTypeRepository;
        this.finalStorageRepository = finalStorageRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public FinalStorageView createFinalStorage(FinalStorageCreateDto dto) {
        FinalStorageCreateBO bo = new FinalStorageCreateBO(dto, finalStorageRepository,
                projectRepository, finalStorageTypeRepository);
        return bo.execute();
    }

    @Override
    public Iterable<FinalStorageView> getFinalStorageByProject(Long projectId) {
        FinalStorageListBO bo = new FinalStorageListBO(projectId, finalStorageRepository);
        return bo.execute();
    }

    @Override
    public Iterable<FinalStorageTypeView> getFinalStorageTypes() {
        FinalStorageTypeListBO bo = new FinalStorageTypeListBO(finalStorageTypeRepository);
        return bo.execute();
    }
}
