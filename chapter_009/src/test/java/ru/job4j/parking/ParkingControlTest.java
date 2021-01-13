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

        ParkingControl parkingControl = new ParkingControl(3, 3);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ"));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkingControl.getCarParking().getParkingPlaces().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkingControl.getTruckParking().getParkingPlaces().forEach(v -> truckParking.append(v.toString()));

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
    @Test
    public void whenNoPlace() {

        ParkingControl parkingControl = new ParkingControl(1, 1);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ"));

        vehicles.forEach(parkingControl::distribute);

        Vehicle track = new Truck("MAZ");

        parkingControl.distribute(track);
    }

    /**
     * When No Place In TruckParkingPlace And put a Truck to CarParking.
     */
    @Test
    public void whenNoPlaceInTruckParkingAddTruck() {

        ParkingControl parkingControl = new ParkingControl(4, 1);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ"),
                new Truck("MAZ"));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkingControl.getCarParking().getParkingPlaces().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkingControl.getTruckParking().getParkingPlaces().forEach(v -> truckParking.append(v.toString()));

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0)).append(vehicles.get(2));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));
    }

    /**
     * When No Place In TruckParkingPlace And No Place In CarParking For Tracks but try to put a Truck.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenNoPlaceInTruckParkingAndNoPlaceInCarParkingForTracksAddTruck() {

        ParkingControl parkingControl = new ParkingControl(3, 1);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ"),
                new Truck("MAZ"));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkingControl.getCarParking().getParkingPlaces().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkingControl.getTruckParking().getParkingPlaces().forEach(v -> truckParking.append(v.toString()));

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

        ParkingControl parkingControl = new ParkingControl(1, 3);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ"));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        parkingControl.getCarParking().getParkingPlaces().forEach(v -> carParking.append(v.toString()));

        StringBuilder truckParking = new StringBuilder();
        parkingControl.getTruckParking().getParkingPlaces().forEach(v -> truckParking.append(v.toString()));

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));

        Vehicle car = new Car("MINI");

        parkingControl.distribute(car);
    }
}
