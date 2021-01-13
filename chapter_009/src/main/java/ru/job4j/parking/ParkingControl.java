package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Parking Control class.
 */
public class ParkingControl {

    private final Parking carParking;
    private final Parking truckParking;

    public ParkingControl(int sizeCar, int sizeTruck) {
        this.carParking = new Parking(sizeCar);
        this.truckParking = new Parking(sizeTruck);
    }

    public void distribute(Vehicle vehicle) {
        if (vehicle.getSize() > 1) {
            parkVehicle(truckParking, vehicle);
        } else {
            parkVehicle(carParking, vehicle);
        }
    }

    public Parking getCarParking() {
        return carParking;
    }

    public Parking getTruckParking() {
        return truckParking;
    }

    private void parkVehicle(Parking parking, Vehicle vehicle) {
        parking.getParkingPlaces().forEach(p -> {
            if (p.accept(vehicle)) {
                p.add(vehicle);
            }
        });
    }
}
