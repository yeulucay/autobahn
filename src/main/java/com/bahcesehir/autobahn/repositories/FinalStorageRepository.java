package com.bahcesehir.autobahn.repositories;

import com.bahcesehir.autobahn.entities.FinalStorage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalStorageRepository extends CrudRepository<FinalStorage, Long> {

    Iterable<FinalStorage> findAllByProjectId(Long projectId);

}
