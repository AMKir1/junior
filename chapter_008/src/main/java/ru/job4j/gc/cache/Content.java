package ru.job4j.gc.cache;
/*
 * Chapter_008. Garbage Collection [#147]
 * Task: 4.1 Реализации кеша на SoftReference [#1592]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.List;

public class Content {

    private List<String> text;

    Content(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return this.text;
    }
}