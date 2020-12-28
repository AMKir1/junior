package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.List;

/**
 * Controll Quality Class.
 */
public class ControllQuality {

    private final List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void distribute(Food food) {
        storages.forEach(s -> {
            if (s.accept(food)) {
                s.add(food);
            }
        });
    }
}