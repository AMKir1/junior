package ru.job4j.tdd;
/*
 * Chapter_009. OOD [#143]
 * Task: Что такое TDD? [#4918]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Calendar;

public class Ticket3D implements Ticket {
    @Override
    public boolean changeDate(Calendar date) {
        return true;
    }

    @Override
    public boolean changePlace(int row, int column) {
        return true;
    }
}
