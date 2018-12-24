package com.bahcesehir.autobahn.repositories;

import com.bahcesehir.autobahn.entities.EnrichmentSourceType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnrichmentSourceTypeRepository extends CrudRepository<EnrichmentSourceType, Long> {

    EnrichmentSourceType findFirstByCode(String code);

}
