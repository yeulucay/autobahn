package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.dto.EndPointCreateDto;
import com.bahcesehir.autobahn.controllers.dto.EndPointTypeCreateDto;
import com.bahcesehir.autobahn.controllers.views.EndPointTypeView;
import com.bahcesehir.autobahn.controllers.views.EndPointView;


public interface EndPointService {

    EndPointTypeView createEndPointType(EndPointTypeCreateDto dto);

    EndPointView createEndPoint(EndPointCreateDto dto);

    Iterable<EndPointView> getEndPointsByProjectId(Long projectId);

    Iterable<EndPointTypeView> getEndPointTypes();
}
