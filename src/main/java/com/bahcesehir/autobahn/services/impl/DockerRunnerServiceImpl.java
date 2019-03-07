package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.views.EndPointView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentContentView;
import com.bahcesehir.autobahn.repositories.EndPointRepository;
import com.bahcesehir.autobahn.repositories.EnrichmentRepository;
import com.bahcesehir.autobahn.services.BO.DockerKafkaClientCreateBO;
import com.bahcesehir.autobahn.services.BO.EndPointByIdBO;
import com.bahcesehir.autobahn.services.BO.EnrichmentByIdBO;
import com.bahcesehir.autobahn.services.DockerRunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class DockerRunnerServiceImpl implements DockerRunnerService {

    @Value("${docker.kafka.image.name}")
    private String kafkaDockerClientName;

    private EndPointRepository endPointRepository;
    private EnrichmentRepository enrichmentRepository;

    @Autowired
    public DockerRunnerServiceImpl(EndPointRepository endPointRepository,
                                   EnrichmentRepository enrichmentRepository) {
        this.endPointRepository = endPointRepository;
        this.enrichmentRepository = enrichmentRepository;
    }

    @Override
    public void createContainer(Long enrichmentId) {

        EnrichmentByIdBO enrichmentByIdBO = new EnrichmentByIdBO(enrichmentId, enrichmentRepository);
        EnrichmentContentView enrichmentContentView = enrichmentByIdBO.execute();

        if(Objects.nonNull(enrichmentContentView)){
            EndPointByIdBO bo = new EndPointByIdBO(enrichmentContentView.getEndPointId(), endPointRepository);
            EndPointView result = bo.execute();
            if(Objects.nonNull(result)){
                switch(result.getEndPointTypeCode()){
                    case "KAFKA":
                        this.createKafkaConsumerContainer(enrichmentContentView.getEnrichmentRules());
                        break;
                }
            }
        }
    }

    @Override
    public void removeUnusedContainers() {

    }

    private void createKafkaConsumerContainer(String enrichmentRules) {

        DockerKafkaClientCreateBO createBO = new DockerKafkaClientCreateBO(
                this.kafkaDockerClientName, enrichmentRules);
        createBO.execute();

    }
}
