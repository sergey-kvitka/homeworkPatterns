package com.kvitka.proxy;

public class DatabaseProxy implements Database {

    private static final String URL = "localhost:";

    private final DatabaseImpl database;

    private int port = 5432;

    public DatabaseProxy(DatabaseImpl database) {
        this.database = database;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String connect() {
        return URL + port + '/' + database.connect();
    }
}