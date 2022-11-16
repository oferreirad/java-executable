package com.diegoferreira.br.executable.designpatterns.factory;

public class Truck implements Transport{
    public void deliver() {
        System.out.println("Deliver package via road");
    }
}
