package com.bahcesehir.autobahn.controllers;

import com.bahcesehir.autobahn.controllers.dto.FinalStorageCreateDto;
import com.bahcesehir.autobahn.controllers.views.FinalStorageView;
import com.bahcesehir.autobahn.services.FinalStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/finalstorage")
public class FinalStorageController {

    private FinalStorageService finalStorageService;

    @Autowired
    public FinalStorageController(FinalStorageService finalStorageService) {
        this.finalStorageService = finalStorageService;
    }

    /**
     * Get final storage types list. e.g. Elastic Search, Cassandra
     * @return
     */
    @GetMapping("/type/list")
    public ResponseEntity<Iterable> getFinalStorageTypes(){
        Iterable results = finalStorageService.getFinalStorageTypes();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    /**
     * Create new final storage in the project
     * @param finalStorage
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<FinalStorageView> createFinalStorage(@RequestBody FinalStorageCreateDto finalStorage){
        FinalStorageView result = finalStorageService.createFinalStorage(finalStorage);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
