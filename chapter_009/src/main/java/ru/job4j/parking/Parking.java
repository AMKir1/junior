package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.List;

/**
 * Parking interface.
 */
public interface Parking {

    /**
     * Add transport to parking.
     * @param vehicle - vehicle.
     */
    void add(Vehicle vehicle);

    /**
     * Checking available seats.
     * @param vehicle - vehicle.
     * @return boolean.
     */
    boolean accept(Vehicle vehicle);

    /**
     * freeing up space.
     * @return list of vehicle.
     */
    List<Vehicle> clear();

}
