package ru.job4j.tdd;
/*
 * Chapter_009. OOD [#143]
 * Task: Что такое TDD? [#4918]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
//        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void returnTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        boolean result = cinema.returnTicket(ticket);
        assertThat(result, is(true));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
//        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void placeIsFree() {
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
//        assertThat(cinema.isFreePlace(1, 1, date), is(true));
    }

    @Test
    public void placeIsNotFree() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(cinema.isFreePlace(1, 1, date), is(false));
    }

    @Test
    public void replaceTicketByData() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();

        date.set(2020, 10, 11, 23, 00);
        Ticket ticket = account.getTicketByCinemaAndPlaceAndData(cinema, 1, 1, date);

        Calendar date2 = Calendar.getInstance();
        date.set(2020, 10, 12, 23, 00);

//        boolean result = ticket.changeDate(date2);
//        assertThat(result, is(true));
    }

    @Test
    public void replaceTicketByPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();

        date.set(2020, 10, 11, 23, 00);
        Ticket ticket = account.getTicketByCinemaAndPlaceAndData(cinema, 1, 1, date);

//        boolean result = ticket.changePlace(1, 2);
//        assertThat(result, is(true));
    }
}
