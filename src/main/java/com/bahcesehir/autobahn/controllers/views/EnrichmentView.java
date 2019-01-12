package com.bahcesehir.autobahn.controllers.views;

import com.bahcesehir.autobahn.entities.Enrichment;


public class EnrichmentView extends BaseView<Enrichment> {

    private Long projectId;
    private Long endPointId;
    private Long enrichmentSourceId;
    private Long finalStorageId;

    public EnrichmentView(Enrichment enrichment) {
        this.map(enrichment);
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEndPointId() {
        return endPointId;
    }

    public void setEndPointId(Long endPointId) {
        this.endPointId = endPointId;
    }

    public Long getEnrichmentSourceId() {
        return enrichmentSourceId;
    }

    public void setEnrichmentSourceId(Long enrichmentSourceId) {
        this.enrichmentSourceId = enrichmentSourceId;
    }

    public Long getFinalStorageId() {
        return finalStorageId;
    }

    public void setFinalStorageId(Long finalStorageId) {
        this.finalStorageId = finalStorageId;
    }
}