package ru.job4j.search;

import org.junit.Test;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/*
 * Chapter_003. Collection. Lite.
 * Task: 2. Написать программу преобразования List в Map. [#10093]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class UserConvertTest {
    @Test
    public void testUserConvert() {
        UserConvert userconvert = new UserConvert();
        List<User> userList = new LinkedList<>();
        User user1 = new User(1, "Peter", "Moscow");
        User user2 = new User(2, "Ivan", "Moscow");
        User user3 = new User(1, "Kirill", "SPB");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, User> hashMap = userconvert.process(userList);
        for (User entry : hashMap.values()) {
            sb.append(entry.getName() + " ");
        }
        sb.toString();
        assertThat(hashMap.get(1).getName(), is(user3.getName()));
    }


}
