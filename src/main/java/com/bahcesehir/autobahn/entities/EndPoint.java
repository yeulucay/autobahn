package com.bahcesehir.autobahn.entities;

import com.bahcesehir.autobahn.commons.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class EndPoint extends BaseEntity {

    private String address;
    private String port;
    private String name;

    @OneToOne
    private Project project;

    @OneToOne
    private EndPointType endPointType;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public EndPointType getEndPointType() {
        return endPointType;
    }

    public void setEndPointType(EndPointType endPointType) {
        this.endPointType = endPointType;
    }
}
