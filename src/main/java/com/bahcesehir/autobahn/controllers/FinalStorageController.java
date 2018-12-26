package com.bahcesehir.autobahn.controllers;

import com.bahcesehir.autobahn.controllers.dto.FinalStorageCreateDto;
import com.bahcesehir.autobahn.controllers.views.FinalStorageView;
import com.bahcesehir.autobahn.services.FinalStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/finalstorage")
public class FinalStorageController {

    private FinalStorageService finalStorageService;

    @Autowired
    public FinalStorageController(FinalStorageService finalStorageService) {
        this.finalStorageService = finalStorageService;
    }

    /**
     * Get final storage by project
     * @param projectId
     * @return
     */
    @GetMapping("/list/{projectId}")
    public ResponseEntity<Iterable> getFinalStorages(@PathVariable Long projectId){
        Iterable results = finalStorageService.getFinalStorageByProject(projectId);
        return new ResponseEntity<>(results, HttpStatus.OK);
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
