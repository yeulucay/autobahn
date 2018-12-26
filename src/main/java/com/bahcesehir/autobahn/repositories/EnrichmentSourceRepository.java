package com.bahcesehir.autobahn.repositories;

import com.bahcesehir.autobahn.entities.EnrichmentSource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnrichmentSourceRepository extends CrudRepository<EnrichmentSource, Long> {

    Iterable<EnrichmentSource> getAllByProject(Long projectId);

}
