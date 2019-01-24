package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.services.helpers.DockerHelper;


public class DockerKafkaClientCreateBO implements BaseBO<Void> {

    private String imageName;
    private String enrichmentRules;

    public DockerKafkaClientCreateBO(String imageName, String enrichmentRules) {
        this.imageName = imageName;
        this.enrichmentRules = enrichmentRules;
    }

    @Override
    public Void execute() {

        Runnable createDockerTask = () -> {
            DockerHelper dockerHelper = new DockerHelper();
            dockerHelper.createDockerContainer(this.imageName, this.enrichmentRules);
        };

        Thread createDockerThread = new Thread(createDockerTask);
        createDockerThread.start();
        

        return null;
    }

    @Override
    public void validate() {

    }
}
