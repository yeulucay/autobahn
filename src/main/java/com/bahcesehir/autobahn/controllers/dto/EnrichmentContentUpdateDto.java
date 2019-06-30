package com.bahcesehir.autobahn.controllers.dto;

public class EnrichmentContentUpdateDto {

    private Long enrichmentId;
    private String enrichmentContent;

    public Long getEnrichmentId() {
        return enrichmentId;
    }

    public void setEnrichmentId(Long enrichmentId) {
        this.enrichmentId = enrichmentId;
    }

    public String getEnrichmentContent() {
        return enrichmentContent;
    }

    public void setEnrichmentContent(String enrichmentContent) {
        this.enrichmentContent = enrichmentContent;
    }
}
