package com.bahcesehir.autobahn.services;


import com.bahcesehir.autobahn.controllers.views.EnrichmentSourceTypeView;

public interface EnrichmentSourceService {

    Iterable<EnrichmentSourceTypeView> getEnrichmentSourceTypes();

}
