package com.bahcesehir.autobahn.entities;

import com.bahcesehir.autobahn.commons.BaseEntity;
import com.bahcesehir.autobahn.entities.converters.DataJsonConverter;
import com.bahcesehir.autobahn.entities.customs.EnrichmentRules;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class Enrichment extends BaseEntity {

    private String name;
    @OneToOne
    private Project project;
    @OneToOne
    private EndPoint endPoint;
    @OneToOne
    private EnrichmentSource enrichmentSource;
    @OneToOne
    private FinalStorage finalStorage;
//    @Convert(converter = DataJsonConverter.class)
//    private EnrichmentRules enrichmentRules;

    private String enrichmentRules;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public EndPoint getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(EndPoint endPoint) {
        this.endPoint = endPoint;
    }

    public EnrichmentSource getEnrichmentSource() {
        return enrichmentSource;
    }

    public void setEnrichmentSource(EnrichmentSource enrichmentSource) {
        this.enrichmentSource = enrichmentSource;
    }

    public FinalStorage getFinalStorage() {
        return finalStorage;
    }

    public void setFinalStorage(FinalStorage finalStorage) {
        this.finalStorage = finalStorage;
    }

    public String getEnrichmentRules() {
        return enrichmentRules;
    }

    public void setEnrichmentRules(String enrichmentRules) {
        this.enrichmentRules = enrichmentRules;
    }
}
