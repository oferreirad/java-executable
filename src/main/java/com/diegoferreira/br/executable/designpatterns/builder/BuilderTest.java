package com.diegoferreira.br.executable.designpatterns.builder;

public class BuilderTest {

    public static void main(String[] args) {
        final HouseDirector houseDirector = new HouseDirector();
        final SimpleHouseBuilder simpleHouseBuilder = new SimpleHouseBuilder();
        final FancyHouseBuilder fancyHouseBuilder = new FancyHouseBuilder();

        House house = null;
        String type = "fancy";

        if (type == "simple") {
            house = houseDirector.buildSimpleHouse(simpleHouseBuilder);
        } else if (type == "fancy") {
            house = houseDirector.buildFancyHouse(fancyHouseBuilder);
        }

        System.out.println(house);

    }

}
