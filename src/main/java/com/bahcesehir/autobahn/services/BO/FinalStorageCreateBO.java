package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.dto.FinalStorageCreateDto;
import com.bahcesehir.autobahn.controllers.views.FinalStorageView;
import com.bahcesehir.autobahn.entities.FinalStorage;
import com.bahcesehir.autobahn.entities.FinalStorageType;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.FinalStorageRepository;
import com.bahcesehir.autobahn.repositories.FinalStorageTypeRepository;
import com.bahcesehir.autobahn.repositories.ProjectRepository;

import java.util.Objects;

public class FinalStorageCreateBO implements BaseBO<FinalStorageView> {

    private FinalStorageRepository finalStorageRepository;
    private ProjectRepository projectRepository;
    private FinalStorageTypeRepository finalStorageTypeRepository;
    private FinalStorageCreateDto dto;

    private Project project;
    private FinalStorageType finalStorageType;

    public FinalStorageCreateBO(FinalStorageCreateDto dto,
                                FinalStorageRepository finalStorageRepository,
                                ProjectRepository projectRepository,
                                FinalStorageTypeRepository finalStorageTypeRepository) {
        this.finalStorageRepository = finalStorageRepository;
        this.projectRepository = projectRepository;
        this.finalStorageTypeRepository = finalStorageTypeRepository;
        this.dto = dto;
    }

    @Override
    public FinalStorageView execute() {

        this.validate();

        FinalStorage fs = new FinalStorage();
        fs.setAddress(dto.getAddress());
        fs.setPort(dto.getPort());
        fs.setDescription(dto.getDescription());
        fs.setName(dto.getName());
        fs.setSchemaName(dto.getSchemaName());
        fs.setUsername(dto.getUsername());
        fs.setPassword(dto.getPassword());

        fs.setFinalStorageType(this.finalStorageType);
        fs.setProject(this.project);

        fs = finalStorageRepository.save(fs);

        if(!Objects.isNull(fs)){
            return new FinalStorageView(fs);
        }
        return null;
    }

    @Override
    public void validate() {

        this.finalStorageType = finalStorageTypeRepository.findById(dto.getTypeId()).orElse(null);
        if(this.finalStorageType == null){
            //TODO: throw exception
        }

        this.project = projectRepository.findById(dto.getProjectId()).orElse(null);
        if(this.project == null){
            //TODO: throw exception
        }

    }
}
