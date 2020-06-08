package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 5.2. Архивировать проект [#861]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgZip {
    private final String[] args;

    private Map<String, String> mapArgs = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
        Arrays.stream(args).forEach(a -> this.mapArgs.put(a.split("=")[0], a.split("=")[1]));
    }

    public boolean valid() {
        boolean result = true;
        if (mapArgs.isEmpty()) {
            result = false;
        }
        for (String value : mapArgs.values()) {
            if (value.length() == 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    public String directory() {
        return this.mapArgs.get("-d");
    }

    public String exclude() {
        return this.mapArgs.get("-e");
    }

    public String output() {
        return this.mapArgs.get("-o");
    }

    public boolean isKey(String key) {
        return this.mapArgs.containsKey(key);
    }
}
