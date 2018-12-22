package com.bahcesehir.autobahn.commons;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CodeBaseEntity extends BaseEntity {

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
