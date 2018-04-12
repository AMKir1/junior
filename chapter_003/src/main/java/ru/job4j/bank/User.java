package ru.job4j.bank;

import java.util.Objects;
/**
 * Chapter_003. Collection. Lite.
 * Task: Банковские переводы. [#10038]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class User {
    /**
     * Поля пользователя.
     */
    private String name;
    private String passport;
    /**
     * Конструктор.
     * @param name
     * @param passport
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
    /**
     * Назыаем пользователя.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Вписываем паспортные данные.
     * @param passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }
    /**
     * Узнаем имя пользователя.
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Получаем паспортные данные.
     */
    public String getPassport() {
        return passport;
    }
    /**
     * Метод сравнения.
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            User user = (User) obj;
            return user.passport.equals(this.passport);
        }
    }
    /**
     * HashCode.
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}
