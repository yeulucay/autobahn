package com.bahcesehir.autobahn.entities;

import com.bahcesehir.autobahn.commons.BaseEntity;

import javax.persistence.Entity;


@Entity
public class EndPointType extends BaseEntity {

    private String code;
    private String description;


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
