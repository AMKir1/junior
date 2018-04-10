package ru.job4j.bank;

import java.util.Objects;

public class User {

    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(getClass() == obj.getClass())) {
            return false;
        } else {
            User user = (User)obj;
            if (user.passport == this.passport) {
                return true;
            } else {
                return false;
            }
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }


}
