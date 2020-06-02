package ru.job4j.collection;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 2. Статистику по коллекции. [#45889]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.collectioin.Analize;
import ru.job4j.collectioin.Analize.*;

import java.util.ArrayList;
import java.util.List;

public class AnalizeTest {
    Analize anal = new Analize();

    List<User> usersPrev = new ArrayList<>();

    @Before
    public void addUsersPrev() {
        usersPrev.add(new User(1, "Andrew"));
        usersPrev.add(new User(2, "Alex"));
        usersPrev.add(new User(3, "Michel"));
    }

    @Test
    public void whenAdd() {

        List<User> usersCurr = new ArrayList<>();

        usersCurr.add(new User(1, "Andrew"));
        usersCurr.add(new User(2, "Alex"));
        usersCurr.add(new User(3, "Michel"));
        usersCurr.add(new User(4, "Kate"));

        Info info = anal.diff(usersPrev, usersCurr);
        assertThat(info.toString(), is("Info{added=1, changed=0, deleted=0}"));
    }

    @Test
    public void whenChange() {

        List<User> usersCurr = new ArrayList<>();

        usersCurr.add(new User(1, "Andrew"));
        usersCurr.add(new User(2, "Alex"));
        usersCurr.add(new User(3, "Boris"));

        Info info = anal.diff(usersPrev, usersCurr);
        assertThat(info.toString(), is("Info{added=0, changed=1, deleted=0}"));
    }

    @Test
    public void whenChangeAndAdd() {

        List<User> usersCurr = new ArrayList<>();

        usersCurr.add(new User(1, "Max"));
        usersCurr.add(new User(2, "Alex"));
        usersCurr.add(new User(3, "Michel"));
        usersCurr.add(new User(4, "Kate"));

        Info info = anal.diff(usersPrev, usersCurr);
        assertThat(info.toString(), is("Info{added=1, changed=1, deleted=0}"));
    }

    @Test
    public void whenDel() {
        List<User> usersCurr = new ArrayList<>();

        usersCurr.add(new User(1, "Andrew"));
        usersCurr.add(new User(2, "Alex"));

        Info info = anal.diff(usersPrev, usersCurr);
        assertThat(info.toString(), is("Info{added=0, changed=0, deleted=1}"));
    }

    @Test
    public void whenChangeAndDel() {
        List<User> usersCurr = new ArrayList<>();

        usersCurr.add(new User(1, "Max"));
        usersCurr.add(new User(2, "Alex"));

        Info info = anal.diff(usersPrev, usersCurr);
        assertThat(info.toString(), is("Info{added=0, changed=1, deleted=1}"));
    }

    @Test
    public void whenDelAndAdd() {
        List<User> usersCurr = new ArrayList<>();

        usersCurr.add(new User(1, "Andrew"));
        usersCurr.add(new User(2, "Alex"));
        usersCurr.add(new User(4, "Stas"));
        usersCurr.add(new User(5, "Stas"));
        usersCurr.add(new User(6, "Stas"));
        Info info = anal.diff(usersPrev, usersCurr);
        assertThat(info.toString(), is("Info{added=3, changed=0, deleted=1}"));
    }

    @Test
    public void whenChangeAndDelAndAdd() {
        List<User> usersCurr = new ArrayList<>();

        usersCurr.add(new User(1, "Max"));
        usersCurr.add(new User(2, "Alex"));
        usersCurr.add(new User(4, "Stas"));
        usersCurr.add(new User(5, "Stas"));
        usersCurr.add(new User(6, "Stas"));
        Info info = anal.diff(usersPrev, usersCurr);
        assertThat(info.toString(), is("Info{added=3, changed=1, deleted=1}"));
    }
}
