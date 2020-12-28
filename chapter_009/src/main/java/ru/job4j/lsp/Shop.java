package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.List;

/**
 * Shop.
 */
public class Shop implements Store {

    /**
     * List of food.
     */
    private List<Food> food;

    /**
     * Designer.
     * @param food - list of food.
     */
    public Shop(List<Food> food) {
        this.food = food;
    }

    /**
     * Put in Store
     * @param f - food.
     */
    @Override
    public void putInStore(Food f) {
        food.add(f);
    }

    /**
     * Getter list of food.
     * @return list.
     */
    @Override
    public List<Food> getStore() {
        return food;
    }
}