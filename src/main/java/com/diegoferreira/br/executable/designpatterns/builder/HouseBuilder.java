package com.diegoferreira.br.executable.designpatterns.builder;

public interface HouseBuilder {

    void reset();

    void buildWalls(Integer walls);

    void buildDoors(Integer doors);

    void buildWindows(Integer windows);

    void buildBathrooms(Integer bathrooms);

    void buildAddress(String address);

    House build();
}
