package com.bahcesehir.autobahn.entities;

import com.bahcesehir.autobahn.commons.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class FinalStorage extends BaseEntity {

    private String name;
    private String description;
    private String address;
    private String port;
    private String schemaName;
    private String username;
    private String password;
    @OneToOne
    private FinalStorageType finalStorageType;
    @OneToOne
    private Project project;

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

    public FinalStorageType getFinalStorageType() {
        return finalStorageType;
    }

    public void setFinalStorageType(FinalStorageType finalStorageType) {
        this.finalStorageType = finalStorageType;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
