package org.softwaretechnologies;

import org.softwaretechnologies.animals.Animal;
import org.softwaretechnologies.animals.AnimalType;

public class AnimalFactory {

    /**
     * Метод для создания животных по типу
     * @param name - имя животного
     * @param type - тип животного
     * @return животное, соответствующее каждому из типов.
     */


    public static Animal createAnimal(String name, AnimalType type) {
        /* TODO в зависимости от type создайте и верните нужное животное */
        if (type == AnimalType.CAT) {
            return new org.softwaretechnologies.animals.Cat(name);
        }

        if (type == AnimalType.DOG) {
            return new org.softwaretechnologies.animals.Dog(name);
        }

        if (type == AnimalType.COW) {
            return new org.softwaretechnologies.animals.Cow(name);
        }

        return null;
    }
}
