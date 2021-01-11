package ru.job4j.lsp;
/*
 * Chapter_009. OOD [#143]
 * Task: 1. Хранилище продуктов [#852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Calendar;
import java.util.Objects;

/**
 * Food class.
 */
public class Food {

    private String name;
    private Calendar expaireDate;
    private Calendar createDate;
    private long price;
    private long disscount;

    public Food(String name, Calendar expaireDate, Calendar createDate, long price, long disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpireDate() {
        return expaireDate;
    }

    public void setExpireDate(Calendar expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDisscount() {
        return disscount;
    }

    public void setDisscount(long disscount) {
        this.disscount = disscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return price == food.price
                && disscount == food.disscount
                && Objects.equals(name, food.name)
                && Objects.equals(expaireDate, food.expaireDate)
                && Objects.equals(createDate, food.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expaireDate, createDate, price, disscount);
    }

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\''
                + ", expaireDate=" + expaireDate
                + ", createDate=" + createDate
                + ", price=" + price
                + ", disscount=" + disscount
                + '}';
    }
}