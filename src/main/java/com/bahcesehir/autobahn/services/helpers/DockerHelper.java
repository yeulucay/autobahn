package com.bahcesehir.autobahn.services.helpers;


import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;

public class DockerHelper {

    public void createDockerContainer(String imageName){
        try {
            DockerClient docker = DefaultDockerClient.fromEnv().build();

            final ContainerConfig containerConfig = ContainerConfig.builder()
                    .image(imageName)
                    .build();

            ContainerCreation creation = docker.createContainer(containerConfig);
            String id = creation.id();
            docker.startContainer(id);

        } catch (DockerCertificateException | InterruptedException | DockerException e) {
            e.printStackTrace();
        }
    }

}
