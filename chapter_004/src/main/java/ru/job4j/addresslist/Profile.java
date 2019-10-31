package main.java.ru.job4j.addresslist;
/**
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Список адресов [#110062]
 * Уникальность элементов и сортировка. [#110225]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address){
        this.address = address;
    }

    public Address getAddress(){
        return this.address;
    }

    public List<Address> collect(List<Profile> profiles ) {
        List<Address> addressList = profiles.stream().map(
                profile -> profile.address
        ).collect(Collectors.toList());
        return addressList;
    }
}