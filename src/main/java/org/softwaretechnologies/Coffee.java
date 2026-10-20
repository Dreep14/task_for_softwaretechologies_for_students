package org.softwaretechnologies;
// TODO: 09.12.2024 Создайте класс базового Coffee, поддерживающий интерфейс CoffeeInterface
//  cтоимость базового напитка равна 50.
//  описание "only coffee"

public class Coffee implements CoffeeInterface {

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public String description() {
        return "only coffee";
    }
}

