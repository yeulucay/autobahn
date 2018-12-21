package com.bahcesehir.autobahn.controllers;


import com.bahcesehir.autobahn.services.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/commons")
public class CommonsController {

    private DataTypeService dataTypeService;

    @Autowired
    public CommonsController(DataTypeService dataTypeService) {
        this.dataTypeService = dataTypeService;
    }

    @GetMapping("/datatypes")
    public ResponseEntity<Iterable> getAllDataTypes(){
        Iterable result = dataTypeService.getDataTypes();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
