package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Controll Quality Class.
 */
public class ControllQuality {

    /**
     * choose store object for strategy.
     */
    private static ChooseStore chooseStore;

    /**
     * Placing products in the correct storage.
     * @param foods - list of food.
     * @param stores - map of stores.
     */
    public void moveTheFood(List<Food> foods, Map<String, Store> stores) {
       for (Food f : foods) {
           long passed = getSpantTime(f);
           if (passed < 25) {
               chooseStore = new ChooseStore(stores.get("warehouse"));
               chooseStore.putInStore(f);
           } else if (passed >= 25 && passed < 75) {
               chooseStore = new ChooseStore(stores.get("shop"));
               chooseStore.putInStore(f);
           } else if (passed >= 75 && passed < 100) {
               f.setDisscount(10);
               chooseStore = new ChooseStore(stores.get("shop"));
               chooseStore.putInStore(f);
           } else {
               chooseStore = new ChooseStore(stores.get("trash"));
               chooseStore.putInStore(f);
           }
       }
    }

    /**
     * Method for determining the degree of expiry of foods.
     * @param food - food.
     * @return long.
     */
    private Long getSpantTime(Food food) {
        Calendar start = food.getCreateDate();
        Calendar finish = food.getExpaireDate();
        Calendar now = Calendar.getInstance();
        if (start.getTimeInMillis() != finish.getTimeInMillis()) {
            long period = finish.getTimeInMillis() - start.getTimeInMillis();
            long passed = now.getTimeInMillis() - start.getTimeInMillis();
            return (100 * passed) / period;
        }
        return 100L;
    }
}