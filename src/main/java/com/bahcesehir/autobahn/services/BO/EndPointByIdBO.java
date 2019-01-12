package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EndPointView;
import com.bahcesehir.autobahn.entities.EndPoint;
import com.bahcesehir.autobahn.repositories.EndPointRepository;


public class EndPointByIdBO implements BaseBO<EndPointView> {

    private EndPointRepository endPointRepository;
    private Long endpointId;

    public EndPointByIdBO(Long endpointId, EndPointRepository endPointRepository) {
        this.endpointId = endpointId;
        this.endPointRepository = endPointRepository;
    }

    @Override
    public EndPointView execute() {
        EndPoint ep = endPointRepository.findById(endpointId).orElse(null);
        return new EndPointView(ep);
    }

    @Override
    public void validate() {

    }
}
