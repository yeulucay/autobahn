package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.entities.EndPoint;

public interface EndPointService {

    public Iterable<EndPoint> getAllEndPoints();

    public EndPoint getEndPointById(Long id);

    public Iterable<EndPoint> getEndPointsByProject(Long projectId);
}
