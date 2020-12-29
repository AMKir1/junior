package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
/**
 * Car class.
 */
public class Car extends Vehicle {
    /**
     * Designer.
     *
     * @param name - vehicle's name.
     * @param size - vehicle's size for parking.
     */
    public Car(String name, int size) {
        super(name, size);
    }
}
