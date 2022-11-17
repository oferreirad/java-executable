package com.diegoferreira.br.executable.designpatterns.builder;

public class HouseDirector {

    House buildFancyHouse(FancyHouseBuilder builder) {
        builder.reset();
        builder.buildAddress("Street 123");
        builder.buildWalls(20);
        builder.buildBathrooms(5);
        builder.buildDoors(4);
        builder.buildWindows(10);
        return builder.build();
    }

    House buildSimpleHouse(SimpleHouseBuilder builder) {
        builder.reset();
        builder.buildAddress("Street 0");
        builder.buildWalls(4);
        builder.buildBathrooms(1);
        builder.buildDoors(1);
        builder.buildWindows(2);
        return builder.build();
    }

}
