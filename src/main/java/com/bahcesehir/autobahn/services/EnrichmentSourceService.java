package com.bahcesehir.autobahn.services;


import com.bahcesehir.autobahn.controllers.dto.EnrichmentSourceCreateDto;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceTypeView;
import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceView;

public interface EnrichmentSourceService {

    EnrichmentSourceView createEnrichmentSource(EnrichmentSourceCreateDto dto);

    Iterable<EnrichmentSourceView> getEnrichmentSources(Long endpointId);

    Iterable<EnrichmentSourceTypeView> getEnrichmentSourceTypes();

}
