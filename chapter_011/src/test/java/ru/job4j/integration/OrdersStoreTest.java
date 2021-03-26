package ru.job4j.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrdersStoreTest {
    private BasicDataSource pool;
    private OrderStore store;

    @Before
    public void setUp() throws SQLException {
        pool = new BasicDataSource.Builder()
                .buildDriverClassName("org.hsqldb.jdbcDriver")
                .buildUrl("jdbc:hsqldb:mem:tests;sql.syntax_pgs=true")
                .buildUsername("sa")
                .buildMaxTotal(2)
                .build();
        store = new OrderStore(pool);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("./db/update_001.sql")))
        ) {
            br.lines().forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool.getConnection().prepareStatement(builder.toString()).executeUpdate();
    }

    @Test
    public void whenSaveOrderAndFindAllOneRowWithDescription() throws SQLException {
        store.save(Order.of("name1", "description1"));
        List<Order> all = (List<Order>) store.findAll();
        assertThat(all.size(), is(1));
        assertThat(all.get(0).getDescription(), is("description1"));
        assertThat(all.get(0).getId(), is(1));
    }

    @Test
    public void whenSaveOrderAndFindById() throws SQLException {
        store.save(Order.of("name1", "description1"));
        Order order = store.findById(store.findByName("name1").getId());
        assertThat(order.getName(), is("name1"));
        assertThat(order.getDescription(), is("description1"));
        assertThat(order.getId(), is(1));
    }

    @Test
    public void whenSaveOrderAndFindByName() throws SQLException {
        store.save(Order.of("name1", "description1"));
        Order order = store.findByName("name1");
        assertThat(order.getName(), is("name1"));
        assertThat(order.getDescription(), is("description1"));
        assertThat(order.getId(), is(1));
    }

    @Test
    public void whenSaveOrderAndUpdate() throws SQLException {
        store.save(Order.of("name1", "description1"));
        Order order = store.findByName("name1");
        order.setName("New name");
        boolean res = store.update(order);
        assertThat(res, is(true));
        order = store.findByName("New name");
        assertThat(order.getDescription(), is("description1"));
        assertThat(order.getId(), is(1));
    }

    @After
    public void done() throws SQLException {
        pool.getConnection().prepareStatement("DROP TABLE orders").executeUpdate();
    }


}