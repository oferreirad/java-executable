package com.diegoferreira.br.executable.designpatterns.factory;

public class FactoryTest {


    public static void main(String[] args) {
        TransportEnum transportType = TransportEnum.ROAD;
        Transport transportPackage = null;

        switch (transportType) {
            case ROAD:
                transportPackage = new RoadLogistics().createTransport();
                break;
            case SEA:
                transportPackage = new SeaLogistics().createTransport();
                break;
            case AIR:
                throw new RuntimeException("Delivery method not implemented");
        }
        transportPackage.deliver();
    }

}
