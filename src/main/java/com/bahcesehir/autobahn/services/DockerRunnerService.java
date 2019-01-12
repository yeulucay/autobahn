package com.bahcesehir.autobahn.services;


public interface DockerRunnerService {

    void createContainer(Long enrichmentId);

    void removeUnusedContainers();
}
