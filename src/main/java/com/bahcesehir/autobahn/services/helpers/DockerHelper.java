package com.bahcesehir.autobahn.services.helpers;


import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerCertificateException;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DockerHelper {

    public void createDockerContainer(String imageName, String enrichmentRules){
        try {
            final DockerClient docker = DefaultDockerClient.fromEnv().build();

            final HostConfig hostConfig = HostConfig.builder().build();

            final ContainerConfig containerConfig = ContainerConfig.builder()
                    .hostConfig(hostConfig)
                    .image(imageName)
                    .build();

            final ContainerCreation creation = docker.createContainer(containerConfig);
            final String id = creation.id();

            final ContainerInfo info = docker.inspectContainer(id);

            docker.startContainer(id);


            final String[] command = {"sh", "-c",
                    "mkdir /App/meta; echo '"+enrichmentRules+"' > /App/meta/rules.json"};
            final String execId = docker.execCreate(id, command).id();
            docker.execStart(execId);

//            InputStream enrichmentRulesStream = new ByteArrayInputStream(enrichmentRules.getBytes());
//            docker.copyToContainer(enrichmentRulesStream, id, "/App/meta/rules.json");

            docker.close();

        } catch (DockerCertificateException | InterruptedException | DockerException e) {
            e.printStackTrace();
        }
    }

}
