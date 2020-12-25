package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: 1. Отчеты. [#850].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.List;
import java.util.function.Predicate;

/**
 * Storage interface.
 */
public interface Store {

    /**
     * Find list of employee by filter.
     * @param filter - filter.
     * @return List of employee.
     */
    List<Employee> findBy(Predicate<Employee> filter);
}
