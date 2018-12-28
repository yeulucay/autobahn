package com.bahcesehir.autobahn.controllers.views;


public class EnrichmentColumnNamesView {

    private Iterable<String> columnNames;

    public EnrichmentColumnNamesView(Iterable<String> columnNames) {
        this.columnNames = columnNames;
    }

    public Iterable<String> getColumnNames() {
        return columnNames;
    }
}
