package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.views.DataTypeView;
import org.springframework.stereotype.Service;


public interface DataTypeService {

    Iterable<DataTypeView> getDataTypes();

}
