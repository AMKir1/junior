package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: 1. Отчеты. [#850].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.function.Predicate;

/**
 * Class for creating reports.
 */
public class ReportEngine {
    /**
     * Employee storage.
     */
    private Store store;

    /**
     * Designer.
     */
    public ReportEngine(Store store) {
        this.store = store;
    }

    /**
     * Creating an old report.
     * @param filter - filter.
     * @return string.
     */
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }

    /**
     * Creating a report for Developer.
     * @param filter - filter.
     * @return string.
     */
    public String generateForDeveloper(Predicate<Employee> filter) {
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

    /**
     * Creating a report for HR.
     * @param filter - filter.
     * @return string.
     */
    public String generateForHR(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }

    /**
     * Creating a report for Accounting.
     * @param filter - filter.
     * @return string.
     */
    public String generateForAccounting(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; OtherSalary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";");
        }
        return text.toString();
    }
}
