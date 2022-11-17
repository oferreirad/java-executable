package com.diegoferreira.br.executable.designpatterns.builder;

public class House {

    private Integer walls;
    private Integer doors;
    private Integer windows;
    private Integer bathrooms;
    private String address;

    public Integer getWalls() {
        return walls;
    }

    public Integer getDoors() {
        return doors;
    }

    public Integer getWindows() {
        return windows;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public String getAddress() {
        return address;
    }

    protected void setWalls(Integer walls) {
        this.walls = walls;
    }

    protected void setDoors(Integer doors) {
        this.doors = doors;
    }

    protected void setWindows(Integer windows) {
        this.windows = windows;
    }

    protected void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "House{" +
                "walls=" + walls +
                ", doors=" + doors +
                ", windows=" + windows +
                ", bathrooms=" + bathrooms +
                ", address='" + address + '\'' +
                '}';
    }
}
