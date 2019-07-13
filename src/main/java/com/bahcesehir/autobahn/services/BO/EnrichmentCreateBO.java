package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.dto.EnrichmentSyncDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentContentView;
import com.bahcesehir.autobahn.entities.*;
import com.bahcesehir.autobahn.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EnrichmentCreateBO implements BaseBO<EnrichmentContentView> {

    private EnrichmentRepository enrichmentRepository;
    private ProjectRepository projectRepository;
    private EnrichmentSourceRepository enrichmentSourceRepository;
    private FinalStorageRepository finalStorageRepository;
    private EndPointRepository endPointRepository;
    private DataTypeRepository dataTypeRepository;
    private EnrichmentSyncDto dto;

    private Project project;
    private EndPoint endPoint;
    private EnrichmentSource enrichmentSource;
    private FinalStorage finalStorage;
    private DataType dataType;

    @Autowired
    public EnrichmentCreateBO(EnrichmentRepository enrichmentRepository,
                              EnrichmentSourceRepository enrichmentSourceRepository,
                              FinalStorageRepository finalStorageRepository,
                              EndPointRepository endPointRepository,
                              DataTypeRepository dataTypeRepository,
                              ProjectRepository projectRepository) {
        this.enrichmentRepository = enrichmentRepository;
        this.enrichmentSourceRepository = enrichmentSourceRepository;
        this.finalStorageRepository = finalStorageRepository;
        this.endPointRepository = endPointRepository;
        this.dataTypeRepository = dataTypeRepository;
        this.projectRepository = projectRepository;
    }

    public void setDto(EnrichmentSyncDto dto){
        this.dto = dto;
    }

    @Override
    public EnrichmentContentView execute() {
        this.validate();
        Enrichment enrichment = enrichmentRepository.findById(dto.getId()).orElse(new Enrichment());
//        if(dto.getId() == null){
//            enrichment = new Enrichment();
//        } else {
//            enrichment =
//        }

        enrichment.setProject(project);
        enrichment.setDataType(dataType);
        enrichment.setEndPoint(endPoint);
        enrichment.setFinalStorage(finalStorage);
        enrichment.setEnrichmentRules(dto.getEnrichmentRules());
        enrichment.setName(dto.getName());
        enrichment.setEnrichmentSource(enrichmentSource);

        Enrichment result = enrichmentRepository.save(enrichment);

        if(result != null){
            return new EnrichmentContentView(result);
        }

        return null;
    }

    @Override
    public void validate() {
        if(dto != null){
            project = projectRepository.findById(dto.getProjectId()).orElse(null);
            endPoint = endPointRepository.findById(dto.getEndPointId()).orElse(null);
            enrichmentSource = enrichmentSourceRepository.findById(dto.getEnrichmentSourceId()).orElse(null);
            finalStorage = finalStorageRepository.findById(dto.getFinalStorageId()).orElse(null);
            dataType = dataTypeRepository.findById(dto.getDataTypeId()).orElse(null);
        }

    }
}
