package com.diegoferreira.br.executable.designpatterns.abstractfactory;

import com.diegoferreira.br.executable.designpatterns.abstractfactory.victorian.VictorialFurnitureFactory;

public class AbstractFactoryTest {
    
public static void main(String[] args) {
    FurnitureFactory victorianFactory = new VictorialFurnitureFactory();

    Chair victorianChair = victorianFactory.createChair();

    System.out.println(victorianChair.toString());

}

}
