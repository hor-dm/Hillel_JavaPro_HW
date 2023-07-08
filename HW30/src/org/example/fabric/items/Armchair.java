package org.example.fabric.items;

import org.example.fabric.Furniture;

public class Armchair implements Furniture {

    @Override
    public void makeFurniture() {
        System.out.println("Armchair was created");
    }
}
