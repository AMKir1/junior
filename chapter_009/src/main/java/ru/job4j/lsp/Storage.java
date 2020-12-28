package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.List;

/**
 * Storage interface.
 */
public interface Storage {

    /**
     * add food to storage.
     * @param food - food.
     */
    void add(Food food);

    /**
     * add in storage.
     * @param food
     */
    boolean accept(Food food);

    /**
     * clear storage.
     * @return list of food.
     */
    List<Food> clear();
}