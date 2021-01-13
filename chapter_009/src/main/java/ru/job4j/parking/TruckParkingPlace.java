package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */
import java.util.List;

public class TruckParkingPlace implements ParkingPlace {

    private long number;

    /**
     * Designer.
     * @param number - number of place.
     */
    public TruckParkingPlace(long number) {
        this.number = number;
    }

    /**
     * Add transport to parking.
     *
     * @param vehicle - vehicle.
     */
    @Override
    public void add(Vehicle vehicle) {

    }

    /**
     * Checking available seats.
     *
     * @param vehicle - vehicle.
     * @return boolean.
     */
    @Override
    public boolean accept(Vehicle vehicle) {
        return false;
    }

    /**
     * freeing up space.
     *
     * @return list of vehicle.
     */
    @Override
    public List<Vehicle> clear() {
        return null;
    }
}
