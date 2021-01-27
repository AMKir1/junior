package ru.job4j.email;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 2. ExecutorService рассылка почты.[63097#453879].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class User {

    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{"
                + "username='" + username
                + ", email='" + email
                + '}';
    }
}
