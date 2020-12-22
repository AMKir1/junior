package ru.job4j.tdd;
/*
 * Chapter_009. OOD [#143]
 * Task: Что такое TDD? [#4918]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {
    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return null;
    }

    @Override
    public void add(Session session) {

    }
    @Override
    public boolean returnTicket(Ticket ticket) {
        return true;
    }

    @Override
    public boolean isFreePlace(int row, int column, Calendar date) {
        return false;
    }
}
