package ru.job4j.gc.cache;
/*
 * Chapter_008. Garbage Collection [#147]
 * Task: 4.1 Реализации кеша на SoftReference [#1592]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CacheFileReader {
    public List<String> getFileContent(String filename) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            in.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
}