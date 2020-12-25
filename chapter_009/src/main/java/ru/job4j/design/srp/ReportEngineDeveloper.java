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
public class ReportEngineDeveloper implements Report {
    /**
     * Employee storage.
     */
    private Store store;

    /**
     * Designer.
     */
    public ReportEngineDeveloper(Store store) {
        this.store = store;
    }

    /**
     * Creating a report for Developer.
     * @param filter - filter.
     * @return string.
     */
    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html><head></head><body>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<div>").append(employee.getName()).append("</div>")
                    .append("<div>").append(employee.getHired()).append("</div>")
                    .append("<div>").append(employee.getFired()).append("</div>")
                    .append("<div>").append(employee.getSalary()).append("</div>");
        }
        text.append("</body><html>");
        return text.toString();
    }
}
