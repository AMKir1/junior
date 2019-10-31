package test.java.ru.job4j.addresslist;
/**
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Список адресов [#110062]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import main.java.ru.job4j.addresslist.Address;
import main.java.ru.job4j.addresslist.Profile;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {
    /**
     * Проверка записи адресов в список
     */
    @Test
    public void whenGetAddressList() {
        List<Profile> profiles = new ArrayList<>();;
        profiles.add(new Profile(new Address("Москва","Ул. 1", 1, 1)));
        profiles.add(new Profile(new Address("Москва","Ул. 1", 1, 2)));
        profiles.add(new Profile(new Address("Москва","Ул. 1", 1, 3)));
        profiles.add(new Profile(new Address("Москва","Ул. 1", 1, 4)));
        profiles.add(new Profile(new Address("Москва","Ул. 1", 1, 5)));
        profiles.add(new Profile(new Address("Москва","Ул. 1", 1, 6)));

        List<Address> addresses = profiles.stream().map(
                profile -> profile.getAddress()
        ).collect(Collectors.toList());

        assertThat(6, is(addresses.size()));
        assertThat("Ул. 1", is(addresses.get(0).getStreet()));
    }

}