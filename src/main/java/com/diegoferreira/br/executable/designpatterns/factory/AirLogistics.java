package com.diegoferreira.br.executable.designpatterns.factory;

public class AirLogistics implements LogisticsFactory{
    @Override
    public Transport createTransport() {
        return new Plane();
    }
}
