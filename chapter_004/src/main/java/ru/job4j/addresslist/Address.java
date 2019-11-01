package ru.job4j.addresslist;
/**
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Список адресов [#110062]
 * Уникальность элементов и сортировка. [#110225]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.2
 */
public class Address {
    private int id;
    private String city;
    private String street;
    private int home;
    private int apartment;

    Address(int id, String city, String street, int home, int apartment) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    String getStreet() {
        return this.street;
    }

    public int getHome() {
        return this.home;
    }

    public int getApartment() {
        return this.apartment;
    }

    String getCity() {
        return this.city;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        return  city.equals(address.city)
                && street.equals(address.street)
                && home == address.home
                && apartment == address.apartment;
    }

    @Override
    public int hashCode() {
        return id;
    }
}