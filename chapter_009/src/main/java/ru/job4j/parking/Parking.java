package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Parking class
 */
public class Parking {

    private int parkingSize;
    private List<ParkingPlace> parkingPlaces;

    /**
     * Designer.
     * @param parkingSize - size.
     */
    public Parking(int parkingSize) {
        this.parkingSize = parkingSize;
        this.parkingPlaces = new ArrayList<>(this.parkingSize);
    }

    /**
     * getter parking size.
     * @return int.
     */
    public int getParkingSize() {
        return parkingSize;
    }

    /**
     * getter parking places.
     * @return
     */
    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaces;
    }
}
