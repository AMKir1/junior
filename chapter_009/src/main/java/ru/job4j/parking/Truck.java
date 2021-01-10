package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
/**Parking
 * Truck class.
 */
public class Truck extends Vehicle {
    /**
     * Designer.
     *
     * @param name - vehicle's name.
     */
    public Truck(String name) {
        super(name, 3);
    }
}
