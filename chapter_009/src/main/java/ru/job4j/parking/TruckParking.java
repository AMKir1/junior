package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.ArrayList;
import java.util.List;

public class TruckParking implements Parking {

    private int size;
    private List<Vehicle> vehicles;

    /**
     * Designer.
     * @param size - size of list.
     */
    public TruckParking(int size) {
        this.size = size;
        this.vehicles = new ArrayList<>(this.size);
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
