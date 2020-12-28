package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.List;

/**
 * Store interface.
 */
public interface Store {

    /**
     * put in store.
     * @param food
     */
    void putInStore(Food food);

    /**
     * get store.
     * @return
     */
    List<Food> getStore();
}