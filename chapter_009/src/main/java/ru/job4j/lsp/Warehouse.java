package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.List;

/**
 * Warehouse class.
 */
public class Warehouse implements Store {
    /**
     * food.
     */
    private List<Food> food;

    /**
     * Designer.
     * @param food - list of food.
     */
    public Warehouse(List<Food> food) {
        this.food = food;
    }

    /**
     * Getter list of food.
     * @return list.
     */
    @Override
    public List<Food> getStore() {
        return food;
    }

    /**
     * Add food to store;
     * @param f - food;
     */
    @Override
    public void putInStore(Food f) {
        this.food.add(f);
    }
}
