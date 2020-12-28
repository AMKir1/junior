package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Warehouse class.
 */
public class Warehouse implements Storage {

    private List<Food> foods;

    public Warehouse(List<Food> foods) {
        this.foods = foods;
    }

    /**
     * add food to storage.
     *
     * @param food - food.
     */
    @Override
    public void add(Food food) {
        foods.add(food);
    }

    /**
     * add in storage.
     *
     * @param food
     */
    @Override
    public boolean accept(Food food) {
        long created = food.getCreateDate().getTimeInMillis();
        long expaire = food.getExpaireDate().getTimeInMillis();
        long accept = (((Calendar.getInstance().getTimeInMillis() - created) * 100) / (expaire - created));
        return accept < 25;
    }

    /**
     * clear storage.
     *
     * @return list of food.
     */
    @Override
    public List<Food> clear() {
        List<Food> result = new ArrayList<>(foods);
        foods.clear();
        return result;
    }
}
