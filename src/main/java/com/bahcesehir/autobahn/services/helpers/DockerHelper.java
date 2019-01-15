package com.bahcesehir.autobahn.services.helpers;


import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.*;

public class DockerHelper {

    public void createDockerContainer(String imageName){
        try {
            final DockerClient docker = DefaultDockerClient.fromEnv().build();

            final HostConfig hostConfig = HostConfig.builder().build();

            final ContainerConfig containerConfig = ContainerConfig.builder()
                    .hostConfig(hostConfig)
                    .image("autobahnkafkaconsumer")
                    .build();

            final ContainerCreation creation = docker.createContainer(containerConfig);
            final String id = creation.id();

            final ContainerInfo info = docker.inspectContainer(id);

            docker.startContainer(id);

            docker.close();

        } catch (DockerCertificateException | InterruptedException | DockerException e) {
            e.printStackTrace();
        }
    }

}
