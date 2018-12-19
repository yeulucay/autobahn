package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.dto.CreateEndPointDto;
import com.bahcesehir.autobahn.controllers.dto.CreateEndPointTypeDto;
import com.bahcesehir.autobahn.controllers.views.EndPointTypeView;
import com.bahcesehir.autobahn.controllers.views.EndPointView;


public interface EndPointService {

    EndPointTypeView createEndPointType(CreateEndPointTypeDto dto);

    EndPointView createEndPoint(CreateEndPointDto dto);

    Iterable<EndPointView> getEndPointsByProjectId(Long projectId);

    Iterable<EndPointTypeView> getEndPointTypes();
}
