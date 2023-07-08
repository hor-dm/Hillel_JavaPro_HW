package org.example.fabric.creators;

import org.example.fabric.items.Chair;
import org.example.fabric.Creator;
import org.example.fabric.Furniture;

public class ChairCreator extends Creator {
    @Override
    public Furniture factoryMethod() {
        return new Chair();
    }
}
