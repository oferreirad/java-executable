package com.diegoferreira.br.executable.designpatterns.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        DatabaseSingleton db = DatabaseSingleton.getInstance();

        System.out.println(db.getDatabaseUrl());
        System.out.println(db.toString());
    }
}
