package com.bahcesehir.autobahn.repositories;


import com.bahcesehir.autobahn.entities.EndPointType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndPointTypeRepository extends CrudRepository<EndPointType, Long> {
}
