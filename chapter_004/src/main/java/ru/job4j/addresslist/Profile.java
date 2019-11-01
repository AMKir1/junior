package ru.job4j.addresslist;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Список адресов [#110062]
 * Уникальность элементов и сортировка. [#110225]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.2
 */
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Profile {
    private Address address;

    Profile() {

    }

    Profile(Address address) {
        this.address = address;
    }

    private Address getAddress() {
        return this.address;
    }

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                profile -> profile.address
        ).collect(Collectors.toList());
    }

    List<Address> getUnicAddresses(List<Profile> profiles) {
        return profiles.stream().map(
                Profile::getAddress
        ).sorted(Comparator.comparing(Address::getCity)).distinct().collect(Collectors.toList());
    }
}