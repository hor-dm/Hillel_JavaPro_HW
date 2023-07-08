package org.example.fabric.creators;

import org.example.fabric.Creator;
import org.example.fabric.Furniture;
import org.example.fabric.items.Sofa;

public class SofaCreator extends Creator {
    @Override
    public Furniture factoryMethod() {
        return new Sofa();
    }
}
