package com.bahcesehir.autobahn.controllers.views;


public class EnrichmentTableNamesView {

    private Iterable<String> tableNames;

    public EnrichmentTableNamesView(Iterable<String> tableNames) {
        this.tableNames = tableNames;
    }

    public Iterable<String> getTableNames() {
        return tableNames;
    }
}
