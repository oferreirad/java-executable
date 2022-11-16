package com.diegoferreira.br.executable.designpatterns.factory;

public class Plane implements Transport{
    @Override
    public void deliver() {
        System.out.println("Delivering package via air");
    }
}
