package org.softwaretechnologies.animals;

public enum AnimalType {
    CAT {
        @Override
        public Animal createAnimal(String name) {
            return new Cat(name);
        }
    },
    DOG {
        @Override
        public Animal createAnimal(String name) { return new Dog(name); }
    },
    COW {
        @Override
        public Animal createAnimal(String name) {
            return new Cow(name);
        }
    };

    public abstract Animal createAnimal(String name);
}