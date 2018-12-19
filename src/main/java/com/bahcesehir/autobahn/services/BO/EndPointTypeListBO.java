package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.EndPointTypeView;
import com.bahcesehir.autobahn.entities.EndPointType;
import com.bahcesehir.autobahn.repositories.EndPointTypeRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class EndPointTypeListBO implements BaseBO<Iterable<EndPointTypeView>> {

    private EndPointTypeRepository endPointTypeRepository;

    public EndPointTypeListBO(EndPointTypeRepository endPointTypeRepository) {
        this.endPointTypeRepository = endPointTypeRepository;
    }

    @Override
    public Iterable<EndPointTypeView> execute() {
        Iterable<EndPointType> endpointTypes = endPointTypeRepository.findAll();
        return StreamSupport.stream(endpointTypes.spliterator(), false)
                .map(EndPointTypeView::new)
                .collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
