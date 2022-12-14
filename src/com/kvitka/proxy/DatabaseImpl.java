package com.kvitka.proxy;

public class DatabaseImpl implements Database {

    private final String dbName;

    public DatabaseImpl(String dbName) {
        this.dbName = dbName;
    }

    @Override
    public String connect() {
        return dbName;
    }
}