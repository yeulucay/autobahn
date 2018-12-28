package com.bahcesehir.autobahn.services;

import com.bahcesehir.autobahn.controllers.views.EnrichmentTableNamesView;

public interface MetaService
{
    EnrichmentTableNamesView getEnrichmentTableNames(Long enrichmentSourceId);
}
