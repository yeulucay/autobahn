package com.bahcesehir.autobahn.services.impl;

import com.bahcesehir.autobahn.controllers.views.DataTypeView;
import com.bahcesehir.autobahn.repositories.DataTypeRepository;
import com.bahcesehir.autobahn.services.BO.DataTypeListBO;
import com.bahcesehir.autobahn.services.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataTypeServiceImpl implements DataTypeService {

    private DataTypeRepository dataTypeRepository;

    @Autowired
    public DataTypeServiceImpl(DataTypeRepository dataTypeRepository) {
        this.dataTypeRepository = dataTypeRepository;
    }

    @Override
    public Iterable<DataTypeView> getDataTypes() {
        DataTypeListBO bo = new DataTypeListBO(this.dataTypeRepository);
        return bo.execute();
    }
}
