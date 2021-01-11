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
 * Shop.
 */
public class Shop implements Storage {

    private List<Food> foods;

    public Shop(List<Food> foods) {
        this.foods = foods;
    }

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        long created = food.getCreateDate().getTimeInMillis();
        long expaire = food.getExpireDate().getTimeInMillis();
        long accept = (((Calendar.getInstance().getTimeInMillis() - created) * 100) / (expaire - created));
        if (accept >= 25 && accept < 100) {
            if (accept >= 75) {
                food.setDisscount(10);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> result = new ArrayList<>(foods);
        foods.clear();
        return result;
    }
}