package ru.job4j.addresslist;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Список адресов [#110062]
 * Уникальность элементов и сортировка. [#110225]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.2
 */
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {
    /*
     * Проверка записи адресов в список
     */
    @Test
    public void whenGetAddressList() {
        List<Profile> profiles = new ArrayList<>();
        Profile profile = new Profile();
        profiles.add(new Profile(new Address(1, "Москва", "Ул. 1", 1, 1)));
        profiles.add(new Profile(new Address(2, "Москва", "Ул. 1", 1, 2)));
        profiles.add(new Profile(new Address(3, "Москва", "Ул. 1", 1, 3)));
        profiles.add(new Profile(new Address(4, "Москва", "Ул. 1", 1, 4)));
        profiles.add(new Profile(new Address(5, "Москва", "Ул. 1", 1, 5)));
        profiles.add(new Profile(new Address(6, "Москва", "Ул. 1", 1, 6)));

        List<Address> addresses = profile.collect(profiles);

        assertThat(6, is(addresses.size()));
        assertThat("Ул. 1", is(addresses.get(0).getStreet()));
    }
    /*
     * Проверка записей уникальных отсортированных адресов в список
     */
    @Test
    public void whenGetUnicAddressList() {
        List<Profile> profiles = new ArrayList<>();
        Profile profile = new Profile();
        profiles.add(new Profile(new Address(1, "Москва", "Ул. 1", 1, 1)));
        profiles.add(new Profile(new Address(1, "Астрахань", "Ул. 2", 1, 2)));
        profiles.add(new Profile(new Address(1, "Москва", "Ул. 1", 1, 1)));
        profiles.add(new Profile(new Address(1, "Москва", "Ул. 1", 1, 4)));
        profiles.add(new Profile(new Address(1, "Москва", "Ул. 1", 1, 4)));
        profiles.add(new Profile(new Address(1, "СПБ", "Ул. 1", 1, 6)));

        List<Address> addresses = profile.getUnicAddresses(profiles);

        assertThat(4, is(addresses.size()));
        assertThat("Астрахань", is(addresses.get(0).getCity()));
    }
}