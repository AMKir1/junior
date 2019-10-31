package main.java.ru.job4j.addresslist;
/**
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Список адресов [#110062]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment){
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }
}