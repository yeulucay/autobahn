package com.bahcesehir.autobahn.controllers.views;


import com.bahcesehir.autobahn.entities.EndPoint;


public class EndPointView extends BaseView<EndPoint>{

    private String address;
    private String port;
    private String name;
    private Long projectId;
    private String projectName;
    private String endPointTypeCode;

    public EndPointView(EndPoint e){
        this.map(e);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEndPointTypeCode() {
        return endPointTypeCode;
    }

    public void setEndPointTypeCode(String endPointTypeCode) {
        this.endPointTypeCode = endPointTypeCode;
    }
}
