package com.bahcesehir.autobahn.controllers.views;

import com.bahcesehir.autobahn.entities.FinalStorage;


public class FinalStorageView extends BaseView<FinalStorage> {

    private String name;
    private String description;
    private String address;
    private String port;
    private String schemaName;
    private String username;
    private String password;
    private Long finalStorageTypeId;
    private String finalStorageTypeCode;
    private Long projectId;
    private String projectName;

    public FinalStorageView(FinalStorage finalStorage){
        this.map(finalStorage);
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

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
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

    public Long getFinalStorageTypeId() {
        return finalStorageTypeId;
    }

    public void setFinalStorageTypeId(Long finalStorageTypeId) {
        this.finalStorageTypeId = finalStorageTypeId;
    }

    public String getFinalStorageTypeCode() {
        return finalStorageTypeCode;
    }

    public void setFinalStorageTypeCode(String finalStorageTypeCode) {
        this.finalStorageTypeCode = finalStorageTypeCode;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
