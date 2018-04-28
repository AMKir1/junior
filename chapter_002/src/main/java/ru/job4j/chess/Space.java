package ru.job4j.chess;
/**
 * Chapter_002. Chess.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class Space {

    private int x, y;
    /**
     * Конструктор клетки
     * @param x
     * @param y
     */
    public Space(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получаем Х
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Получаем Y
     * @return y
     */
    public int getY() {
        return y;
    }
}
