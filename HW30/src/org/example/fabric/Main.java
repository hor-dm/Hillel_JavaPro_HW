package org.example.fabric;

import org.example.fabric.creators.ArmchairCreator;
import org.example.fabric.creators.ChairCreator;
import org.example.fabric.creators.SofaCreator;

public class Main {
    public static void main(String[] args) {
        Creator[] creators = {new SofaCreator(), new ArmchairCreator(), new ChairCreator()};

        for(Creator c: creators){
            Furniture furniture = c.factoryMethod();
            furniture.makeFurniture();
        }
    }
}
