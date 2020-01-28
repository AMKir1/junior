package ru.job4j.map;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 2. Не перекрывать equals hashCode [#1005]
 *       3. Переопределить только hashCode [#1003]
 *       4. Переопределить только equals [#1004]
 *       5. Перекрывать и equals и hashCode [#1002]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    Calendar calendar = new GregorianCalendar(2020, 0, 25);
    User user1 = new User("ALEX", 5, calendar);
    User user2 = new User("ALEX", 5, calendar);

    Map<User, Object> userObjectMap = new HashMap<>();

    @Test
    public void mapTest() {
        userObjectMap.put(user1, "ALEX");
        userObjectMap.put(user2, "JERY");
        System.out.println(user1.equals(user2));
        userObjectMap.forEach((user, o) -> System.out.println(user.hashCode()));
        System.out.println(userObjectMap);
        System.out.println(userObjectMap.get(user1));
        System.out.println(userObjectMap.get(user2));
    }
}
