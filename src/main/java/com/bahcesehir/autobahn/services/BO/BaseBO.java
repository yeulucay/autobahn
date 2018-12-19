package com.bahcesehir.autobahn.services.BO;


public interface BaseBO<T> {

    T execute();
    void validate();
}
