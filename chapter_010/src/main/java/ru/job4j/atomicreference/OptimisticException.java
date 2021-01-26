package ru.job4j.atomicreference;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Неблокирующий кеш[4741#453912].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class OptimisticException extends RuntimeException {
    public OptimisticException(String errorMessage) {
        super(errorMessage);
    }
}
