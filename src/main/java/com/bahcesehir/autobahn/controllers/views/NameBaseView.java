package com.bahcesehir.autobahn.controllers.views;

public abstract class NameBaseView<T> extends BaseView<T> {

    private String name;

    public NameBaseView(T e){
        this.map(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
