package com.bahcesehir.autobahn.controllers.views;


import org.modelmapper.ModelMapper;

public abstract class BaseView<T> {

    private Long id;

    void map(T t){
        ModelMapper mapper = new ModelMapper();
        mapper.map(t, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
