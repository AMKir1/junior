package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: 1. Отчеты. [#850].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 2.
 */
import java.util.function.Predicate;

/**
 * Class for creating reports.
 */
public class ReportEngineHR implements Report {
    /**
     * Employee storage.
     */
    private Store store;

    /**
     * Designer.
     */
    public ReportEngineHR(Store store) {
        this.store = store;
    }

    /**
     * Creating a report for HR.
     * @param filter - filter.
     * @return string.
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
