package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Calendar;

/**
 * Eggs class.
 */
public class Eggs extends Food {

    public Eggs(String name, Calendar expaireDate, Calendar createDate, long price, long disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }
}