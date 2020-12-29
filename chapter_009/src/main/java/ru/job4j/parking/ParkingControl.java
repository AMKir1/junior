package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.List;

/**
 * Parking Control class.
 */
public class ParkingControl {

    private final List<Parking> parkings;

    public ParkingControl(List<Parking> parkings) {
        this.parkings = parkings;
    }

    public void distribute(Vehicle vehicle) {
        parkings.forEach(p -> {
            if (p.accept(vehicle)) {
                p.add(vehicle);
            }
        });
    }
}
