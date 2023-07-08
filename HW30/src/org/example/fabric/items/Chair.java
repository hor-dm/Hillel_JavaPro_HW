package org.example.fabric.items;

import org.example.fabric.Furniture;

public class Chair implements Furniture {

    @Override
    public void makeFurniture() {
        System.out.println("Chair was created");
    }
}
