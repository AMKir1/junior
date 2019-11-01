package ru.job4j.diapason;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951]
 * Task: Подсчет функции в диапазоне. [#24251]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.*;
import java.util.function.Function;

class Functions {
    /*
     * Метод для проведения расчетов в диапазоне.
     * @param start - начало диапзона
     * @param end - конец диапазона
     * @param func - функция
     * @return result - список с результатами
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new LinkedList<>();
        for (; start != end; start++) {
            result.add(func.apply((double) start));
        }
        return result;
    }
}
