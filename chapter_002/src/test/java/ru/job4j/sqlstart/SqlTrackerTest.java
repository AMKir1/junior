package ru.job4j.sqlstart;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* class TrackerTest
*/
public class SqlTrackerTest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("desc").size(), is(1));
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

/**
*
*/
@Test
public void whenAddItem() throws Exception {
    Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
    Item item1 = new Item("test1");
    tracker.add(item1);
    assertThat(tracker.findByName(item1.getName()).get(0).getName(), is(item1.getName()));
}
/**
*
*/
@Test
public void whenUpdateItem() throws Exception {
    Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
    Item item1 = tracker.findByName("test1").get(0);
    tracker.replace(item1.getId(), new Item("test2", "testDescription2", 1L, "1"));
    assertThat(tracker.findById(item1.getId()).getName(), is("test2"));
}
/**
*
*/
@Test
public void whenDeleteItem() throws Exception {
    Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
    Item item3 = new Item("Test3");
    tracker.add(item3);
    tracker.delete(item3.getId());
    Store expected = null;
    assertThat(tracker.findById(item3.getId()), is(expected));
}

/**
*
*/
@Test
public void whenFindByName() throws SQLException {
    Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
    List<Item> items = tracker.findByName("test_1");
    assertThat(items.size(), is(3));
}
/**
*
*/
@Test
public void whenFindByIdAndNotNull() throws SQLException {
    Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
    assertThat(tracker.findById("10").getName(), is("test_3434"));
}
/**
*
*/
@Test
public void whenFindByIdAndNull() throws SQLException {
    Store tracker = new SqlTracker(ConnectionRollback.create(this.init()));
    Store expected = null;
    assertThat(tracker.findById("7"), is(expected));
}
}