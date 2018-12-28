package com.bahcesehir.autobahn.entities;

import com.bahcesehir.autobahn.commons.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class Enrichment extends BaseEntity {

    @OneToOne
    private Project project;

    

}
