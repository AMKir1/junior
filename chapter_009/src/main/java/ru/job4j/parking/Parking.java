package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Parking class
 */
public abstract class Parking {

    private int size;
    private Vehicle[] parkingPlaces;

    /**
     * Designer.
     * @params size - parking size.
     */
    public Parking(int size) {
        this.size = size;
        this.parkingPlaces = new Vehicle[this.size];
    }
    /**
     * getter parking size.
     * @return int.
     */
    public int size() {
        return size;
    }

    /**
     * getter parking places.
     * @return
     */
    public Vehicle[] getParkingPlaces() {
        return this.parkingPlaces;
    }

    public void add(int free, Vehicle vehicle) {
        this.parkingPlaces[free] = vehicle;
    }
}
