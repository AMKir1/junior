package main.java.ru.job4j.addresslist;
/**
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Список адресов [#110062]
 * Уникальность элементов и сортировка. [#110225]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Address {
    private int id;
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(int id, String city, String street, int home, int apartment){
        this.id = id;
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null||getClass()!= obj.getClass()){
            return false;
        }
        Address address =(Address) obj;
        return  city.equals(address.city) &&
                street.equals(address.street) &&
                home == address.home &&
                apartment == address.apartment;
    }

    @Override
    public int hashCode() {
        return id;
    }
}