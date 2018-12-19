package com.bahcesehir.autobahn.controllers;

import com.bahcesehir.autobahn.controllers.dto.CreateEndPointDto;
import com.bahcesehir.autobahn.controllers.dto.CreateEndPointTypeDto;
import com.bahcesehir.autobahn.controllers.views.EndPointTypeView;
import com.bahcesehir.autobahn.controllers.views.EndPointView;
import com.bahcesehir.autobahn.services.EndPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/endpoints")
public class EndPointController {

    private EndPointService endPointService;

    @Autowired
    public EndPointController(EndPointService endPointService) {
        this.endPointService = endPointService;
    }

    /**
     * Creates new endpoint type
     * @param endpointType
     * @return
     */
    @PostMapping("/type/create")
    public ResponseEntity<EndPointTypeView> createEndPointType(@RequestBody CreateEndPointTypeDto endpointType){
        EndPointTypeView result = this.endPointService.createEndPointType(endpointType);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Creates new endpoint
     * @param endpoint
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<EndPointView> createEndPoint(@RequestBody CreateEndPointDto endpoint){
        EndPointView result = this.endPointService.createEndPoint(endpoint);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * List all endpoint types
     * @return
     */
    @GetMapping("/type/list")
    public ResponseEntity<Iterable> getEndPointTypes(){
        Iterable results = endPointService.getEndPointTypes();
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    /**
     * List all endpoints of a project
     * @param projectId
     * @return
     */
    @GetMapping("/list/{projectId}")
    public ResponseEntity<Iterable> getEndPointsByProjectId(@PathVariable Long projectId){
        Iterable results = endPointService.getEndPointsByProjectId(projectId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
