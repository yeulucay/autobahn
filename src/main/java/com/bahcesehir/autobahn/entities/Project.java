package com.bahcesehir.autobahn.entities;


import com.bahcesehir.autobahn.commons.BaseEntity;

import javax.persistence.Entity;


@Entity
public class Project extends BaseEntity {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
