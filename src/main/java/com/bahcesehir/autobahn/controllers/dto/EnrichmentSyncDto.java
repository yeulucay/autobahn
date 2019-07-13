package com.bahcesehir.autobahn.controllers.dto;


public class EnrichmentSyncDto {

    private Long id;
    private Long projectId;
    private Long endPointId;
    private Long enrichmentSourceId;
    private Long finalStorageId;
    private String enrichmentRules;
    private Long dataTypeId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEnrichmentRules() {
        return enrichmentRules;
    }

    public void setEnrichmentRules(String enrichmentRules) {
        this.enrichmentRules = enrichmentRules;
    }

    public Long getDataTypeId() {
        return dataTypeId;
    }

    public void setDataTypeId(Long dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
