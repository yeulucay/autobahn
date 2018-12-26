package com.bahcesehir.autobahn.controllers.views;

import com.bahcesehir.autobahn.entities.EnrichmentSource;


public class EnrichmentSourceView extends BaseView<EnrichmentSource>{

    private String name;
    private String description;
    private String address;
    private String port;
    private String projectName;
    private String enrichmentSourceTypeCode;
    private String username;
    private String password;
    private String databaseName;

    public EnrichmentSourceView(EnrichmentSource enrichmentSource){
        this.map(enrichmentSource);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEnrichmentSourceTypeCode() {
        return enrichmentSourceTypeCode;
    }

    public void setEnrichmentSourceTypeCode(String enrichmentSourceTypeCode) {
        this.enrichmentSourceTypeCode = enrichmentSourceTypeCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
}
