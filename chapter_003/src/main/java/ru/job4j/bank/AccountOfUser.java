package ru.job4j.bank;
/**
 * Chapter_003. Collection. Lite.
 * Task: Банковские переводы. [#10038]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class AccountOfUser {
    /**
     * Поля счета.
     */
    private double value; //кол-во денег
    private String requisites; //банковский счёт
    /**
     * Конструктор класса.
     * @param value
     * @param requisites
     */
    public AccountOfUser(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }
    /**
     * Получаем количесвто денег на счету.
     * @return
     */
    public double getValue() {
        return value;
    }
    /**
     * Получаем номер счета.
     * @return
     */
    public String getRequisites() {
        return requisites;
    }
    /**
     * Устанавливаем номер счета.
     * @param requisites
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }
    /**
     * Записываем сумму денег на счету.
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }
}
