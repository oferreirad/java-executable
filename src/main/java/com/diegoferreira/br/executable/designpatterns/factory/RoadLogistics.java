package com.diegoferreira.br.executable.designpatterns.factory;

public class RoadLogistics implements LogisticsFactory {

    public Transport createTransport() {
        return new Ship();
    }
}
