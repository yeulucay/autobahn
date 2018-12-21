package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.views.DataTypeView;
import com.bahcesehir.autobahn.entities.DataType;
import com.bahcesehir.autobahn.repositories.DataTypeRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class DataTypeListBO implements BaseBO<Iterable<DataTypeView>> {

    private DataTypeRepository dataTypeRepository;

    public DataTypeListBO(DataTypeRepository dataTypeRepository) {
        this.dataTypeRepository = dataTypeRepository;
    }

    @Override
    public Iterable<DataTypeView> execute() {
        Iterable<DataType> dataTypes = dataTypeRepository.findAll();

        return StreamSupport.stream(dataTypes.spliterator(), false)
                .map(DataTypeView::new).collect(Collectors.toList());
    }

    @Override
    public void validate() {

    }
}
