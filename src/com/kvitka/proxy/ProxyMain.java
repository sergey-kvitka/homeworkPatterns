package com.kvitka.proxy;

public class ProxyMain {
    public static void main(String[] args) {

        DatabaseImpl database = new DatabaseImpl("usersDB");

        System.out.println(database.connect());

        DatabaseProxy databaseProxy = new DatabaseProxy(database);

        databaseProxy.setPort(1234);

        System.out.println(databaseProxy.connect());
    }
}