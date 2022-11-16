package com.diegoferreira.br.executable.designpatterns.factory;

public class SeaLogistics implements LogisticsFactory{
    public Transport createTransport() {
        return new Truck();
    }
}
