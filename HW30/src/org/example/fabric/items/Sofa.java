package org.example.fabric.items;

import org.example.fabric.Furniture;

public class Sofa implements Furniture {

    @Override
    public void makeFurniture() {
        System.out.println("Sofa was created");
    }
}
