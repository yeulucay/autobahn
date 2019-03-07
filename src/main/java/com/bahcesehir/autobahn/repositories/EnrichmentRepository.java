package com.bahcesehir.autobahn.repositories;

import com.bahcesehir.autobahn.entities.Enrichment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EnrichmentRepository extends CrudRepository<Enrichment, Long> {

    List<Enrichment> findAllByProjectId(Long projectId);

}
