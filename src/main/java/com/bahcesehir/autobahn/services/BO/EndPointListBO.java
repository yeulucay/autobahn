package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EndPointView;
import com.bahcesehir.autobahn.entities.EndPoint;
import com.bahcesehir.autobahn.repositories.EndPointRepository;
import com.bahcesehir.autobahn.repositories.EndPointTypeRepository;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class EndPointListBO implements BaseBO<Iterable<EndPointView>> {

    private EndPointRepository endPointRepository;
    private Long projectId;

    public EndPointListBO(EndPointRepository endPointRepository,
                          Long projectId) {
        this.endPointRepository = endPointRepository;
        this.projectId = projectId;
    }

    @Override
    public Iterable<EndPointView> execute() {
        Iterable<EndPoint> endpoints = endPointRepository.findAllByProjectId(projectId);
        return StreamSupport.stream(endpoints.spliterator(), false)
                .map(EndPointView::new).collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
