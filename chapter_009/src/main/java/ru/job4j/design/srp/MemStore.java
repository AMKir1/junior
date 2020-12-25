package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: 1. Отчеты. [#850].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A class that implements storage interface.
 */
public class MemStore implements Store {

    /**
     *  list of employee.
     */
    private final List<Employee> employees = new ArrayList<>();

    /**
     * Adding employee to list of employee.
     * @param em - employee.
     */
    public void add(Employee em) {
        employees.add(em);
    }

    /**
     * Find list of employee by filter.
     * @param filter - filter.
     * @return list of employee.
     */
    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }

}
