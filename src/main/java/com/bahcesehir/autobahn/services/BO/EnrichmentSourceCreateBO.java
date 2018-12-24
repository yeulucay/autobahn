package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.dto.EnrichmentSourceCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;
import com.bahcesehir.autobahn.entities.EnrichmentSource;
import com.bahcesehir.autobahn.entities.EnrichmentSourceType;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceRepository;
import com.bahcesehir.autobahn.repositories.EnrichmentSourceTypeRepository;

import java.util.Objects;


public class EnrichmentSourceCreateBO implements BaseBO<EnrichmentSourceView> {

    private EnrichmentSourceCreateDto dto;
    private EnrichmentSourceRepository repository;
    private EnrichmentSourceTypeRepository typeRepository;
    private EnrichmentSourceType sourceType;

    public EnrichmentSourceCreateBO(EnrichmentSourceCreateDto dto,
                                    EnrichmentSourceRepository repository,
                                    EnrichmentSourceTypeRepository typeRepository) {
        this.dto = dto;
        this.repository = repository;
        this.typeRepository = typeRepository;
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

        es = repository.save(es);
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

    }
}
