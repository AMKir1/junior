package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853] (Tests)
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Tests.
 */
public class ParkingControlTest {

    /**
     * when Parking Is Free.
     */
    @Test
    public void whenParkingIsFree() {
        List<Parking> parkings = List.of(new CarParking(3), new TruckParking(3));

        ParkingControl parkingControl = new ParkingControl(parkings);

        List<Vehicle> vehicles = List.of(
                new Car("KIA", 1),
                new Truck("KAMAZ", 1));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkings.get(0).clear().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkings.get(1).clear().forEach(v -> truckParking.append(v.toString()));

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));
    }

    /**
     * When No place.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoPlace() {
        List<Parking> parkings = List.of(new CarParking(1), new TruckParking(1));

        ParkingControl parkingControl = new ParkingControl(parkings);

        List<Vehicle> vehicles = List.of(
                new Car("KIA", 1),
                new Truck("KAMAZ", 1));

        vehicles.forEach(parkingControl::distribute);

        Vehicle track = new Truck("MAZ", 1);

        parkingControl.distribute(track);
    }

    /**
     * When No Place In TruckParking And put a Truck to CarParking.
     */
    @Test
    public void whenNoPlaceInTruckParkingAddTruck() {
        List<Parking> parkings = List.of(new CarParking(4), new TruckParking(1));

        ParkingControl parkingControl = new ParkingControl(parkings);

        List<Vehicle> vehicles = List.of(
                new Car("KIA", 1),
                new Truck("KAMAZ", 1),
                new Truck("MAZ", 1));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkings.get(0).clear().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkings.get(1).clear().forEach(v -> truckParking.append(v.toString()));

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0)).append(vehicles.get(2));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));
    }

    /**
     * When No Place In TruckParking And No Place In CarParking For Tracks but try to put a Truck.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoPlaceInTruckParkingAndNoPlaceInCarParkingForTracksAddTruck() {
        List<Parking> parkings = List.of(new CarParking(3), new TruckParking(1));

        ParkingControl parkingControl = new ParkingControl(parkings);

        List<Vehicle> vehicles = List.of(
                new Car("KIA", 1),
                new Truck("KAMAZ", 1),
                new Truck("MAZ", 1));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkings.get(0).clear().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkings.get(1).clear().forEach(v -> truckParking.append(v.toString()));

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));
    }

    /**
     * When No Place In CarParking but try to put a car.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoPlaceInCarParkingAddCar() {
        List<Parking> parkings = List.of(new CarParking(1), new TruckParking(3));

        ParkingControl parkingControl = new ParkingControl(parkings);

        List<Vehicle> vehicles = List.of(
                new Car("KIA", 1),
                new Truck("KAMAZ", 1));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkings.get(0).clear().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkings.get(0).clear().forEach(v -> truckParking.append(v.toString()));

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));

        Vehicle car = new Car("MINI", 1);

        parkingControl.distribute(car);
    }
}
