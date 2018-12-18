package com.bahcesehir.autobahn.repositories;

import com.bahcesehir.autobahn.entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
