package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.services.helpers.DockerHelper;


public class DockerKafkaClientCreateBO implements BaseBO<Void> {

    private String imageName;

    public DockerKafkaClientCreateBO(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public Void execute() {

        Runnable createDockerTask = () -> {
            DockerHelper dockerHelper = new DockerHelper();
            dockerHelper.createDockerContainer(this.imageName);
        };

        Thread createDockerThread = new Thread(createDockerTask);
        createDockerThread.start();
        

        return null;
    }

    @Override
    public void validate() {

    }
}
