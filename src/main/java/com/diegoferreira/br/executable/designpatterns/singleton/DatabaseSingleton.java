package com.diegoferreira.br.executable.designpatterns.singleton;

import java.util.Objects;

public class DatabaseSingleton {

    private static DatabaseSingleton instance;

    private String databaseUrl;

    private String databaseUsername;

    private String databasePassword;

    private DatabaseSingleton() {

    }

    private DatabaseSingleton(String databaseUrl, String databasePassword, String databaseUsername) {
        this.databasePassword = databasePassword;
        this.databaseUrl = databaseUrl;
        this.databaseUsername = databaseUsername;
    }

    public static DatabaseSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseSingleton("url", "pass", "username");
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }
}
