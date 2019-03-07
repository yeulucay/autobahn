package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.views.EnrichmentContentView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentView;

import java.util.List;

public interface EnrichmentService {

    EnrichmentContentView getEnrichmentById(Long enrichmentId);

    List<EnrichmentView> getEnrichmentByProjectId(Long projectId);
}
