package org.softwaretechnologies;

import org.softwaretechnologies.animals.*;

public class AnimalFactory {
    public static Animal createAnimal(String name, AnimalType type) {
        return type == null ? null : type.createAnimal(name);
    }
}