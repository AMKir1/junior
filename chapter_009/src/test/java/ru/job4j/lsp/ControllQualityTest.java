package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
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
        ControllQuality controllQuality = new ControllQuality();

        Calendar created = getInstance();
        Calendar expired = getInstance();
        expired.add(Calendar.MONTH, 1);

        Map<String, Store> stores = new HashMap<>();
        stores.put("warehouse", new Warehouse(new ArrayList<>()));
        stores.put("shop", new Shop(new ArrayList<>()));
        stores.put("trash", new Trash(new ArrayList<>()));

        List<Food> food = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired, created, 140, 0));

        controllQuality.moveTheFood(food, stores);

        StringBuilder warehouse = new StringBuilder();
        stores.get("warehouse").getStore().forEach(f -> warehouse.append(f.toString()));

        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));

        assertThat(warehouse.toString(), is(result.toString()));
        assertThat(stores.get("warehouse").getStore().size(), is(3));
        assertThat(stores.get("shop").getStore().size(), is(0));
        assertThat(stores.get("trash").getStore().size(), is(0));
    }

    /**
     * when All Products Put In Shop.
     */
    @Test
    public void whenAllProductsPutInShop() {
        ControllQuality controllQuality = new ControllQuality();

        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);

        Calendar expired = getInstance();
        expired.add(Calendar.DATE, 60);

        Map<String, Store> stores = new HashMap<>();
        stores.put("warehouse", new Warehouse(new ArrayList<>()));
        stores.put("shop", new Shop(new ArrayList<>()));
        stores.put("trash", new Trash(new ArrayList<>()));

        List<Food> food = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired, created, 140, 0));

        controllQuality.moveTheFood(food, stores);

        StringBuilder shop = new StringBuilder();
        stores.get("shop").getStore().forEach(f -> shop.append(f.toString()));

        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));

        assertThat(shop.toString(), is(result.toString()));
        assertThat(stores.get("warehouse").getStore().size(), is(0));
        assertThat(stores.get("shop").getStore().size(), is(3));
        assertThat(stores.get("trash").getStore().size(), is(0));
    }

    /**
     * when All Products Put In Trash.
     */
    @Test
    public void whenAllProductsPutInTrash() {
        ControllQuality controllQuality = new ControllQuality();

        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);

        Calendar expired = getInstance();

        Map<String, Store> stores = new HashMap<>();
        stores.put("warehouse", new Warehouse(new ArrayList<>()));
        stores.put("shop", new Shop(new ArrayList<>()));
        stores.put("trash", new Trash(new ArrayList<>()));

        List<Food> food = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired, created, 140, 0));

        controllQuality.moveTheFood(food, stores);

        StringBuilder trash = new StringBuilder();
        stores.get("trash").getStore().forEach(f -> trash.append(f.toString()));

        StringBuilder result = new StringBuilder();
        food.forEach(f -> result.append(f.toString()));

        assertThat(trash.toString(), is(result.toString()));
        assertThat(stores.get("warehouse").getStore().size(), is(0));
        assertThat(stores.get("shop").getStore().size(), is(0));
        assertThat(stores.get("trash").getStore().size(), is(3));
    }

    /**
     * when Some Products Have Discount In Shop.
     */
    @Test
    public void whenSomeProductsHaveDiscountInShop() {
        ControllQuality controllQuality = new ControllQuality();

        Calendar created = getInstance();
        created.add(Calendar.DATE, -20);

        Calendar expired = getInstance();

        Calendar expired2 = getInstance();
        expired2.add(Calendar.DATE, 1);

        Map<String, Store> stores = new HashMap<>();
        stores.put("warehouse", new Warehouse(new ArrayList<>()));
        stores.put("shop", new Shop(new ArrayList<>()));
        stores.put("trash", new Trash(new ArrayList<>()));

        List<Food> food = List.of(
                new Milk("Домик в дервне", expired, created, 100, 0),
                new Bread("Нарезной", expired, created, 30, 0),
                new Eggs("Лето", expired2, created, 140, 0));

        controllQuality.moveTheFood(food, stores);

        StringBuilder trash = new StringBuilder();
        stores.get("trash").getStore().forEach(f -> trash.append(f.toString()));

        StringBuilder shop = new StringBuilder();
        stores.get("shop").getStore().forEach(f -> shop.append(f.toString()));

        StringBuilder resultTrash = new StringBuilder();
        resultTrash.append(food.get(0).toString()).append(food.get(1).toString());

        StringBuilder resultShop = new StringBuilder();
        resultShop.append(food.get(2).toString());

        assertThat(resultTrash.toString(), is(trash.toString()));
        assertThat(resultShop.toString(), is(shop.toString()));

        assertThat(stores.get("shop").getStore().get(0).getDisscount(), is(10L));

        assertThat(stores.get("warehouse").getStore().size(), is(0));
        assertThat(stores.get("shop").getStore().size(), is(1));
        assertThat(stores.get("trash").getStore().size(), is(2));
    }
}