package com.bahcesehir.autobahn.controllers.views;

import com.bahcesehir.autobahn.entities.EndPointType;


public class EndPointTypeView extends BaseView<EndPointType> {

    private String code;
    private String description;

    public EndPointTypeView(EndPointType e){
        this.map(e);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
