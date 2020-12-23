package ru.job4j.generator;
/*
 * Chapter_009. OOD [#143]
 * Task: Шаблонизатор. [#855]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Map;

public interface Generator {
    String produce(String template, Map<String, String> args);
}
