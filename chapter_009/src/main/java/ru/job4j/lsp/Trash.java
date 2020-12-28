package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.List;

/**
 * Trash class.
 */
public class Trash implements Store {
    /**
     * list of food.
     */
    private List<Food> food;

    /**
     * Designer.
     * @param food - list of food.
     */
    public Trash(List<Food> food) {
        this.food = food;
    }

    /**
     * get store.
     * @return list of food.
     */
    @Override
    public List<Food> getStore() {
        return food;
    }

    /**
     * put in store.
     * @param f - food.
     */
    @Override
    public void putInStore(Food f) {
        food.add(f);
    }
}
