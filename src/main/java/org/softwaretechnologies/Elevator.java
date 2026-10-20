package org.softwaretechnologies;

public final class Elevator {

    /**
     * Этаж, на котором сейчас находится лифт.
     */
    private int currentFloor;

    /**
     * Самый верхний этаж, на который может подняться лифт.
     */
    private final int highestFloor;

    /**
     * Самый нижний этаж, на который может опуститься лифт.
     * (например -3 - в здании три уровня подземной парковки)
     * Если lowestFloor отрицательный, то нулевой этаж существует.
     */
    private final int lowestFloor;

    /**
     * Создает лифт, который передвигается между lowestFloor и highestFloor
     * включительно.
     * Если lowestFloor отрицательный, то нулевой этаж существует.
     * Если lowestFloor -3 то в здании три уровня подземной парковки.
     *
     * @param highestFloor Самый верхний этаж, на который может подняться лифт
     * @param lowestFloor Самый нижний этаж, на который может опуститься лифт
     */
    public Elevator(int lowestFloor, int highestFloor) {
        this.currentFloor = lowestFloor;
        this.highestFloor = highestFloor;
        this.lowestFloor = lowestFloor;
    }

    /**
     * Спускает лифт на этаж ниже.
     */
    private void goDown() {
        currentFloor--;
    }

    /**
     * Поднимает лифт на этаж выше.
     */
    private void goUp() {
        currentFloor++;
    }

    /**
     * Функция передвигает лифт на указанный этаж.
       Используйте функции goUp и goDown.
       Перед каждым изменением этажа выводится сообщение:
       Текущий этаж: номер_текущего_этажа
     * Когда достигнут указанный этаж, вывести сообщение:
       Вы достигли указанного этажа: номер_указанного_этажа
     * Пример: лифт находится на 10 этаже. Вы указали 10 этаж.
     * Все сообщения на экране после вызова функции:
       Вы достигли указанного этажа: 10
     * Пример: лифт находится на 10 этаже. Вы указали 7 этаж.
     * Все сообщения на экране после вызова функции:
       Текущий этаж: 10
       Текущий этаж: 9
       Текущий этаж: 8
       Вы достигли указанного этажа: 7
     * Если указанного этажа не существует, то вывести сообщение:
       Указан неверный этаж
     * Не изменять этаж, на котором сейчас находится лифт, если указан
       несуществующий этаж.
     * @param floor этаж, на который должен переместиться лифт
     */
    public void goToExactFloor(int floor) {
        // TODO: реализуйте вышеуказанную функцию
        if (floor < lowestFloor || floor > highestFloor) {
            System.out.println("Указан неверный этаж");
            return;
        }

        while (currentFloor != floor) {

            System.out.println("Текущий этаж: " + currentFloor);

            if (currentFloor < floor) {
                goUp();
            } else {
                goDown();
            }
        }

        System.out.println("Вы достигли указанного этажа: " + floor);
    }

    /**
     * Этаж, на котором сейчас находится лифт.
     *
     * @return текущий этаж
     */
    public int getCurrentFloor() {
        return currentFloor;
    }
}
