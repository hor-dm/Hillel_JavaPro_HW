package org.example.fabric.creators;

import org.example.fabric.items.Armchair;
import org.example.fabric.Creator;
import org.example.fabric.Furniture;

public class ArmchairCreator extends Creator {
    @Override
    public Furniture factoryMethod() {
        return new Armchair();
    }
}
