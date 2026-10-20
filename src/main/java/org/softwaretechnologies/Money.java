package org.softwaretechnologies;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import static java.lang.Integer.MAX_VALUE;

public class Money {
    private final MoneyType type;
    private final BigDecimal amount;

    public Money(MoneyType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Money равны, если одинаковый тип валют и одинаковое число денег до 4 знака после запятой.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @param o объект для сравнения
     * @return true - равно, false - иначе
     */
    @Override
    public boolean equals(Object o) {
        // TODO: реализуйте вышеуказанную функцию
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (type != money.type) return false;

        if (amount == null && money.amount == null) return true;
        if (amount == null || money.amount == null) return false;

        BigDecimal firstAmount = amount.setScale(4, RoundingMode.HALF_UP);
        BigDecimal secondAmount = money.amount.setScale(4, RoundingMode.HALF_UP);

        return firstAmount.equals(secondAmount);
    }

    /**
     * Формула:
     * (Если amount null 10000, иначе количество денег окрукленные до 4х знаков * 10000) + :
     * если USD , то 1
     * если EURO, то 2
     * если RUB, то 3
     * если KRONA, то 4
     * если null, то 5
     * Если amount округленный до 4х знаков * 10000 >= (Integer.MaxValue - 5), то хеш равен Integer.MaxValue
     * Округление по правилу: если >= 5, то в большую сторону, иначе - в меньшую
     * Пример округления:
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     *
     * @return хеш код по указанной формуле
     */
    @Override
    public int hashCode() {
        // TODO: реализуйте вышеуказанную функцию
        int typeNumber;

        if (type == MoneyType.USD) {
            typeNumber = 1;
        } else if (type == MoneyType.EURO) {
            typeNumber = 2;
        } else if (type == MoneyType.RUB) {
            typeNumber = 3;
        } else if (type == MoneyType.KRONA) {
            typeNumber = 4;
        } else {
            typeNumber = 5;
        }

        if (amount == null) {
            return 10000 + typeNumber;
        }

        BigDecimal roundedAmount = amount.setScale(4, RoundingMode.HALF_UP);
        BigDecimal hashAmount = roundedAmount.multiply(BigDecimal.valueOf(10000));

        if (hashAmount.compareTo(BigDecimal.valueOf(MAX_VALUE - 5L)) >= 0) {
            return MAX_VALUE;
        }

        return hashAmount.intValue() + typeNumber;
    }

    /**
     * Верните строку в формате
     * Тип_ВАЛЮТЫ: количество.XXXX
     * Тип_валюты: USD, EURO, RUB или KRONA
     * количество.XXXX - округленный amount до 4х знаков.
     * Округление по правилу: если >= 5, то в большую сторону, интаче - в меньшую
     * BigDecimal scale = amount.setScale(4, RoundingMode.HALF_UP);
     * <p>
     * Если тип валюты null, то вернуть:
     * null: количество.XXXX
     * Если количество денег null, то вернуть:
     * Тип_ВАЛЮТЫ: null
     * Если и то и то null, то вернуть:
     * null: null
     *
     * @return приведение к строке по указанному формату.
     */
    @Override
    public String toString() {
        // TODO: реализуйте вышеуказанную функцию
        String typeString = (type == null) ? "null" : type.toString();

        String amountString;

        if (amount == null) {

            amountString = "null";

        } else {

            amountString = amount.setScale(4, RoundingMode.HALF_UP).toString();

        }

        return typeString + ": " + amountString;

    }
}
