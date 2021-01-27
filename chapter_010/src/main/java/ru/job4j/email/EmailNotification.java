package ru.job4j.email;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 2. ExecutorService рассылка почты.[63097#453879].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.String.format;

public class EmailNotification {

    ExecutorService pool = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );

    public void emailTo(User user) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                String subject = format("Notification %s to email %s.", user.getUsername(), user.getEmail());
                String body = format("Add a new event to %s", user.getUsername());
                send(subject, body, user.getEmail());
            }
        });
    }

    public void send(String subject, String body, String email) {

    }

    public void close() {
        pool.shutdown();
    }

}
