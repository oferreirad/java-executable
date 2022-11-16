package com.diegoferreira.br.executable.designpatterns.factory;

public class Ship implements Transport{
    public void deliver() {
        System.out.println("Deliver package via sea");
    }
}
