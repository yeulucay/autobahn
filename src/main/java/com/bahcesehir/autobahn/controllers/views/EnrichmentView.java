package com.bahcesehir.autobahn.controllers.views;

import com.bahcesehir.autobahn.entities.Enrichment;


public class EnrichmentView extends BaseView<Enrichment> {

    private Long projectId;
    private String name;
    private String endPointTypeCode;
    private String enrichmentSourceTypeCode;
    private String finalStorageTypeCode;
    private String dataTypeCode;

    public EnrichmentView(Enrichment enrichment) {
        this.map(enrichment);
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndPointTypeCode() {
        return endPointTypeCode;
    }

    public void setEndPointTypeCode(String endPointTypeCode) {
        this.endPointTypeCode = endPointTypeCode;
    }

    public String getEnrichmentSourceTypeCode() {
        return enrichmentSourceTypeCode;
    }

    public void setEnrichmentSourceTypeCode(String enrichmentSourceTypeCode) {
        this.enrichmentSourceTypeCode = enrichmentSourceTypeCode;
    }

    public String getFinalStorageTypeCode() {
        return finalStorageTypeCode;
    }

    public void setFinalStorageTypeCode(String finalStorageTypeCode) {
        this.finalStorageTypeCode = finalStorageTypeCode;
    }

    public String getDataTypeCode() {
        return dataTypeCode;
    }

    public void setDataTypeCode(String dataTypeCode) {
        this.dataTypeCode = dataTypeCode;
    }
}
