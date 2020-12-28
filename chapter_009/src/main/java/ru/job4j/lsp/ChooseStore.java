package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
/**
 * choose store object for strategy.
 */
public class ChooseStore {

    private static Store store;

    public ChooseStore(Store store) {
        this.store = store;
    }

    public static void putInStore(Food food) {
        store.putInStore(food);
    }
}