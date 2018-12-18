package com.bahcesehir.autobahn.repositories;


import com.bahcesehir.autobahn.entities.EndPoint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EndPointRepository extends CrudRepository<EndPoint, Long> {
}
