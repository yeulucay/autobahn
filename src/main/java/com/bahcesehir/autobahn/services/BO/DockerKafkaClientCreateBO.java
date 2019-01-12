package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.services.helpers.DockerHelper;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ContainerConfig;
import com.spotify.docker.client.messages.ContainerCreation;


public class DockerKafkaClientCreateBO implements BaseBO<Void> {

    private String imageName;

    public DockerKafkaClientCreateBO(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public Void execute() {

        DockerHelper dockerHelper = new DockerHelper();
        dockerHelper.createDockerContainer(this.imageName);
        return null;
    }

    @Override
    public void validate() {

    }
}
