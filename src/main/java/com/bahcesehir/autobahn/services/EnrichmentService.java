package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.views.EnrichmentView;

public interface EnrichmentService {

    EnrichmentView getEnrichmentById(Long enrichmentId);

}
