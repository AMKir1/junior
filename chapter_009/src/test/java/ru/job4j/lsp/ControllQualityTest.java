package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */

import static java.util.Calendar.getInstance;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.*;

/**
 * Tests.
 */
public class ControllQualityTest {

    /**
     * when No Expired Products.
     */
    @Test
    public void whenNoExpiredProducts() {
        Calendar created = getInstance();
        Calendar expired = getInstance();
        expired.add(Calendar.MONTH, 1);

        List<Storage> storages = List.of(new Warehouse(new ArrayList<>()), new Shop(new ArrayList<>()), new Trash(new ArrayList<>()));

        ControllQuality controllQuality = new ControllQuality(storages);

        List<Food> foods = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired, created, 140, 0));

        foods.forEach(controllQuality::distribute);

        StringBuilder warehouse = new StringBuilder();
        storages.get(0).clear().forEach(f -> warehouse.append(f.toString()));

        StringBuilder result = new StringBuilder();
        foods.forEach(f -> result.append(f.toString()));

        assertThat(warehouse.toString(), is(result.toString()));
    }

    /**
     * when All Products Put In Shop.
     */
    @Test
    public void whenAllProductsPutInShop() {
        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);

        Calendar expired = getInstance();
        expired.add(Calendar.DATE, 60);

        List<Storage> storages = List.of(new Warehouse(new ArrayList<>()), new Shop(new ArrayList<>()), new Trash(new ArrayList<>()));

        ControllQuality controllQuality = new ControllQuality(storages);

        List<Food> food = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired, created, 140, 0));

        food.forEach(controllQuality::distribute);

        StringBuilder shop = new StringBuilder();
        storages.get(1).clear().forEach(f -> shop.append(f.toString()));

        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));

        assertThat(shop.toString(), is(result.toString()));
    }

    /**
     * when All Products Put In Trash.
     */
    @Test
    public void whenAllProductsPutInTrash() {
        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);

        Calendar expired = getInstance();

        List<Storage> storages = List.of(new Warehouse(new ArrayList<>()), new Shop(new ArrayList<>()), new Trash(new ArrayList<>()));
        ControllQuality controllQuality = new ControllQuality(storages);

        List<Food> food = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired, created, 140, 0));

        food.forEach(controllQuality::distribute);

        StringBuilder trash = new StringBuilder();
        storages.get(2).clear().forEach(f -> trash.append(f.toString()));

        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));

        assertThat(trash.toString(), is(result.toString()));
    }

    /**
     * when Some Products Have Discount In Shop.
     */
    @Test
    public void whenSomeProductsHaveDiscountInShop() {
        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);

        Calendar expired = getInstance();

        Calendar expired2 = getInstance();
        expired2.add(Calendar.DATE, 1);

        List<Storage> storages = List.of(new Warehouse(new ArrayList<>()), new Shop(new ArrayList<>()), new Trash(new ArrayList<>()));

        ControllQuality controllQuality = new ControllQuality(storages);

        List<Food> food = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired2, created, 140, 0));

        food.forEach(controllQuality::distribute);

        StringBuilder trash = new StringBuilder();
        storages.get(2).clear().forEach(f -> trash.append(f.toString()));

        List<Food> shopResult = new ArrayList<>(storages.get(1).clear());

        StringBuilder shop = new StringBuilder();
        shopResult.forEach(f -> shop.append(f.toString()));

        StringBuilder resultTrash = new StringBuilder();
        resultTrash.append(food.get(0).toString()).append(food.get(1).toString());

        StringBuilder resultShop = new StringBuilder();
        resultShop.append(food.get(2).toString());

        assertThat(resultTrash.toString(), is(trash.toString()));
        assertThat(resultShop.toString(), is(shop.toString()));

        assertThat(shopResult.get(0).getDisscount(), is(10L));
    }
}