package com.diegoferreira.br.executable.designpatterns.builder;

public class SimpleHouseBuilder implements HouseBuilder {

    private House house;


    @Override
    public void reset() {
        this.house = new House();
    }

    @Override
    public void buildWalls(Integer walls) {
        this.house.setWalls(walls);
        System.out.println("Building tiny walls");
    }

    @Override
    public void buildDoors(Integer doors) {
        this.house.setDoors(doors);
        System.out.println("Building small doors");
    }

    @Override
    public void buildWindows(Integer windows) {
        this.house.setWindows(windows);
        System.out.println("Building small windows");
    }

    @Override
    public void buildBathrooms(Integer bathrooms) {
        this.house.setBathrooms(bathrooms);
        System.out.println("Building cold bathrooms");
    }

    @Override
    public void buildAddress(String address) {
        this.house.setAddress(address);
        System.out.println("Building regular address");
    }

    @Override
    public House build() {
        return this.house;
    }
}
