package ru.job4j.coffee;
/**
 * Chapter_002. CoffeeMachine.
 * Task: Реализовать выдачу сдачи
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class CoffeeMachine {
    private final static int[] COINS = new int[]{10, 5, 2, 1};

    public int[] toGiveChange(int value, int price) {
        int surrender = value - price; // сдача
        int remainder;             // остаток
        int i = 0;
        int[] result = new int[4];
        if (value >= price) {
            for (int c : COINS) {
                remainder = surrender % c;
                result[i] = (surrender - remainder) / c;
                i++;
                surrender = remainder;
            }
        }
        return result;
    }
}
