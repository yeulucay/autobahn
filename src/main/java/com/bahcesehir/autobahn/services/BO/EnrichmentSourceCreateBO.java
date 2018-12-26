package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.dto.EnrichmentSourceCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.entities.EndPoint;
import com.bahcesehir.autobahn.entities.EnrichmentSource;
import com.bahcesehir.autobahn.entities.EnrichmentSourceType;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.EndPointRepository;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceTypeRepository;
import com.bahcesehir.autobahn.repositories.ProjectRepository;

import java.util.Objects;


public class EnrichmentSourceCreateBO implements BaseBO<EnrichmentSourceView> {

    private EnrichmentSourceCreateDto dto;
    private EnrichmentSourceRepository repository;
    private EnrichmentSourceTypeRepository typeRepository;
    private ProjectRepository projectRepository;
    private EnrichmentSourceType sourceType;
    private Project project;

    public EnrichmentSourceCreateBO(EnrichmentSourceCreateDto dto,
                                    EnrichmentSourceRepository repository,
                                    EnrichmentSourceTypeRepository typeRepository,
                                    ProjectRepository projectRepository) {
        this.dto = dto;
        this.repository = repository;
        this.typeRepository = typeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public EnrichmentSourceView execute() {

        this.validate();

        EnrichmentSource es = new EnrichmentSource();
        es.setAddress(dto.getAddress());
        es.setPort(dto.getPort());
        es.setDatabaseName(dto.getDatabaseName());
        es.setDescription(dto.getDescription());
        es.setName(dto.getName());
        es.setUsername(dto.getUsername());
        es.setPassword(dto.getPassword());
        es.setType(sourceType);
        es.setProject(this.project);

        repository.save(es);
        if(!Objects.isNull(es)){
            return new EnrichmentSourceView(es);
        }
        return null;
    }

    @Override
    public void validate() {

        this.sourceType = typeRepository.findById(dto.getTypeId()).orElse(null);
        if(Objects.isNull(sourceType)){
            //TODO: throw exception
        }

        this.project = projectRepository.findById(dto.getProjectId()).orElse(null);
        if(Objects.isNull(project)){
            //TODO: throw exception
        }

    }
}
