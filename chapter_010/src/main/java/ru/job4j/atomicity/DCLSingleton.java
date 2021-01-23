package ru.job4j.atomicity;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 2. Модель памяти Java[267917#453898].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class DCLSingleton {
    private static volatile DCLSingleton inst;

    public static DCLSingleton instOf() {
        if (inst == null) {
            synchronized (DCLSingleton.class) {
                if (inst == null) {
                    inst = new DCLSingleton();
                }
            }
        }
        return inst;
    }

    private DCLSingleton() {
    }
}
