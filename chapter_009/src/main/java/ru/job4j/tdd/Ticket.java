package ru.job4j.tdd;
/*
 * Chapter_009. OOD [#143]
 * Task: Что такое TDD? [#4918]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Calendar;

public interface Ticket {

    boolean changeDate(Calendar date);

    boolean changePlace(int row, int column);
}
