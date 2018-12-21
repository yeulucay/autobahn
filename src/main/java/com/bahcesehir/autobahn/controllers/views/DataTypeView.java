package com.bahcesehir.autobahn.controllers.views;


import com.bahcesehir.autobahn.entities.DataType;


public class DataTypeView extends BaseView<DataType> {

    private String code;
    private String description;

    public DataTypeView(DataType e){
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
