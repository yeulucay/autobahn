package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.dto.CreateEndPointDto;
import com.bahcesehir.autobahn.controllers.dto.CreateEndPointTypeDto;
import com.bahcesehir.autobahn.controllers.views.EndPointTypeView;
import com.bahcesehir.autobahn.controllers.views.EndPointView;
import com.bahcesehir.autobahn.entities.EndPoint;
import com.bahcesehir.autobahn.repositories.EndPointRepository;
import com.bahcesehir.autobahn.repositories.EndPointTypeRepository;
import com.bahcesehir.autobahn.repositories.ProjectRepository;
import com.bahcesehir.autobahn.services.BO.EndPointCreateBO;
import com.bahcesehir.autobahn.services.BO.EndPointListBO;
import com.bahcesehir.autobahn.services.BO.EndPointTypeCreateBO;
import com.bahcesehir.autobahn.services.BO.EndPointTypeListBO;
import com.bahcesehir.autobahn.services.EndPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EndPointServiceImpl implements EndPointService {

    private EndPointRepository endPointRepository;
    private EndPointTypeRepository endPointTypeRepository;
    private ProjectRepository projectRepository;

    @Autowired
    public EndPointServiceImpl(EndPointRepository endPointRepository,
                               EndPointTypeRepository endPointTypeRepository,
                               ProjectRepository projectRepository) {

        this.endPointRepository = endPointRepository;
        this.endPointTypeRepository = endPointTypeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public EndPointTypeView createEndPointType(CreateEndPointTypeDto dto) {
        EndPointTypeCreateBO bo = new EndPointTypeCreateBO(endPointTypeRepository, dto);
        return bo.execute();
    }

    @Override
    public EndPointView createEndPoint(CreateEndPointDto dto) {
        EndPointCreateBO bo = new EndPointCreateBO(endPointRepository,
                endPointTypeRepository,
                projectRepository,
                dto);
        return bo.execute();
    }

    @Override
    public Iterable<EndPointView> getEndPointsByProjectId(Long projectId) {
        EndPointListBO bo = new EndPointListBO(endPointRepository, projectId);
        return bo.execute();
    }

    @Override
    public Iterable<EndPointTypeView> getEndPointTypes() {
        EndPointTypeListBO bo = new EndPointTypeListBO(endPointTypeRepository);
        return bo.execute();
    }
}
