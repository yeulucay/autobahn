package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.dto.EndPointCreateDto;
import com.bahcesehir.autobahn.controllers.views.EndPointView;
import com.bahcesehir.autobahn.entities.EndPoint;
import com.bahcesehir.autobahn.entities.EndPointType;
import com.bahcesehir.autobahn.entities.Project;
import com.bahcesehir.autobahn.repositories.EndPointRepository;
import com.bahcesehir.autobahn.repositories.EndPointTypeRepository;
import com.bahcesehir.autobahn.repositories.ProjectRepository;

import java.time.LocalDateTime;
import java.util.Objects;

public class EndPointCreateBO implements BaseBO<EndPointView> {

    private EndPointRepository endPointRepository;
    private EndPointTypeRepository endPointTypeRepository;
    private ProjectRepository projectRepository;
    private EndPointCreateDto dto;
    private EndPointType endPointType;
    private Project project;

    public EndPointCreateBO(EndPointRepository endPointRepository,
                            EndPointTypeRepository endPointTypeRepository,
                            ProjectRepository projectRepository,
                            EndPointCreateDto dto) {
        this.endPointRepository = endPointRepository;
        this.endPointTypeRepository = endPointTypeRepository;
        this.projectRepository = projectRepository;
        this.dto = dto;
    }

    @Override
    public EndPointView execute() {
        validate();
        EndPoint ep = new EndPoint();
        ep.setAddress(dto.getAddress());
        ep.setPort(dto.getPort());
        ep.setEndPointType(endPointType);
        ep.setProject(project);
        ep.setCreatedAt(LocalDateTime.now());
        ep = endPointRepository.save(ep);

        if(!Objects.isNull(ep)){
            return new EndPointView(ep);
        }
        return null;
    }

    @Override
    public void validate() {
        this.endPointType = endPointTypeRepository.findById(dto.getTypeId()).orElse(null);
        if(this.endPointType == null){
            //TODO: throw exception
        }
        this.project = projectRepository.findById(dto.getProjectId()).orElse(null);
        if(this.project == null){
            //TODO: throw exception
        }

    }
}
