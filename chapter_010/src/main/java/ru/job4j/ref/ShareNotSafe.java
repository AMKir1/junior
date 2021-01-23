package ru.job4j.ref;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 4. Thread без общих ресурсов[267919#453900]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class ShareNotSafe {
    public static void main(String[] args) throws InterruptedException {
        UserCache cache = new UserCache();
        User user = User.of("name");
        cache.add(user);
        Thread first = new Thread(
                () -> {
                    user.setName("rename");
                }
        );
        first.start();
        first.join();
        System.out.println(cache.findById(1).getName());
    }
}
