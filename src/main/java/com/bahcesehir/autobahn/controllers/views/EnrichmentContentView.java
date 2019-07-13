package com.bahcesehir.autobahn.controllers.views;

import com.bahcesehir.autobahn.entities.Enrichment;


public class EnrichmentContentView extends BaseView<Enrichment> {

    private String name;
    private Long projectId;
    private Long endPointId;
    private Long enrichmentSourceId;
    private Long finalStorageId;
    private String enrichmentRules;
    private Long dataTypeId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrichmentRules() {
        return enrichmentRules;
    }

    public void setEnrichmentRules(String enrichmentRules) {
        this.enrichmentRules = enrichmentRules;
    }

    public EnrichmentContentView(Enrichment enrichment) {
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

    public Long getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Long dataTypeId) {
        this.dataTypeId = dataTypeId;
    }
}
