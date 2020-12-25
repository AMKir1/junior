package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: 1. Отчеты. [#850].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */
import java.util.function.Predicate;

/**
 * Report interface.
 */
public interface Report {

    /**
     * Generate method.
     * @param filter - filter.
     * @return String.
     */
    String generate(Predicate<Employee> filter);
}
