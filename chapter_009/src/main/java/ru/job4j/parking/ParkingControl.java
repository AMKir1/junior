package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.List;

/**
 * Parking Control class.
 */
public class ParkingControl {

    private final Parking parking;

    public ParkingControl(int size) {
        this.parking = new Parking(size);
    }

    public void distribute(Vehicle vehicle) {
        parking.getParkingPlaces().forEach(p -> {
            if (p.accept(vehicle)) {
                p.add(vehicle);
            }
        });
    }
}
