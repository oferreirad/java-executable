package com.diegoferreira.br.executable.designpatterns.abstractfactory.victorian;

import com.diegoferreira.br.executable.designpatterns.abstractfactory.Chair;
import com.diegoferreira.br.executable.designpatterns.abstractfactory.Couch;
import com.diegoferreira.br.executable.designpatterns.abstractfactory.FurnitureFactory;

public class VictorialFurnitureFactory implements FurnitureFactory {

    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Couch createCouch() {
        return new VictorianCouch();
    }
    
}
