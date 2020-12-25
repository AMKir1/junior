package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: 1. Отчеты. [#850].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.Calendar;
import java.util.Objects;

/**
 * Employee class.
 */
public class Employee {

    /**
     * name.
     */
    private String name;

    /**
     * hired.
     */
    private Calendar hired;

    /**
     * fired.
     */
    private Calendar fired;

    /**
     * salary.
     */
    private double salary;

    /**
     * Designer.
     * @param name - name.
     * @param hired - hired.
     * @param fired - fired.
     * @param salary - salary.
     */
    public Employee(String name, Calendar hired, Calendar fired, double salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    /**
     * Get name.
     * @return string.
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get hired.
     * @return Calendar.
     */
    public Calendar getHired() {
        return hired;
    }

    /**
     * Set hired.
     * @param hired - hired.
     */
    public void setHired(Calendar hired) {
        this.hired = hired;
    }

    /**
     * Get Fired.
     * @return Calendar.
     */
    public Calendar getFired() {
        return fired;
    }

    /**
     * Set Fired.
     * @param fired fired.
     */
    public void setFired(Calendar fired) {
        this.fired = fired;
    }

    /**
     * Get Salary.
     * @return double.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set Salary.
     * @param salary - salary.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Equals method.
     * @param o - object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    /**
     * hashCode Method.
     * @return int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
