package com.bahcesehir.autobahn.controllers.views;


import com.bahcesehir.autobahn.entities.DataType;

public abstract class CodeBaseView<T> extends BaseView<T>{

    private String code;
    private String description;

    public CodeBaseView(T e){
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
