package com.bahcesehir.autobahn.services.BO;

import com.bahcesehir.autobahn.controllers.dto.EndPointTypeCreateDto;
import com.bahcesehir.autobahn.controllers.views.EndPointTypeView;
import com.bahcesehir.autobahn.entities.EndPointType;
import com.bahcesehir.autobahn.repositories.EndPointTypeRepository;

import java.util.Objects;


public class EndPointTypeCreateBO implements BaseBO<EndPointTypeView> {

    private EndPointTypeRepository endPointTypeRepository;
    private EndPointTypeCreateDto dto;

    public EndPointTypeCreateBO(EndPointTypeRepository endPointTypeRepository,
                                EndPointTypeCreateDto dto) {
        this.endPointTypeRepository = endPointTypeRepository;
        this.dto = dto;
    }

    @Override
    public EndPointTypeView execute() {
        EndPointType ept = new EndPointType();
        ept.setCode(dto.getCode());
        ept.setDescription(dto.getDescription());
        ept = endPointTypeRepository.save(ept);

        if(!Objects.isNull(ept)){
            return new EndPointTypeView(ept);
        }
        return null;
    }

    @Override
    public void validate() {

    }
}
