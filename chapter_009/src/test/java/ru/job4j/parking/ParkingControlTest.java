package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853] (Tests)
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
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
                new Truck("KAMAZ", 3));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        Vehicle[] carParkingPlaces = parkingControl.getCarParking().getParkingPlaces();
        for (int i = 0; i < carParkingPlaces.length; i++) {
            if (carParkingPlaces[i] != null) {
                carParking.append(carParkingPlaces[i].toString());
            }
        }

        StringBuilder truckParking = new StringBuilder();
        Vehicle[] truckParkingPlaces = parkingControl.getTruckParking().getParkingPlaces();
        for (int i = 0; i < truckParkingPlaces.length; i++) {
            if (truckParkingPlaces[i] != null) {
                truckParking.append(truckParkingPlaces[i].toString());
            }
        }

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
                new Truck("KAMAZ", 3));

        vehicles.forEach(parkingControl::distribute);

        Vehicle track = new Truck("MAZ", 3);
        assertThat(parkingControl.distribute(track), is(false));
    }

    /**
     * When No Place In ParkingTruck And put a Truck to CarParking.
     */
    @Test
    public void whenNoPlaceInTruckParkingAddTruck() {

        ParkingControl parkingControl = new ParkingControl(4, 1);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ", 3),
                new Truck("MAZ", 2));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        Vehicle[] carParkingPlaces = parkingControl.getCarParking().getParkingPlaces();
        for (int i = 0; i < carParkingPlaces.length; i++) {
            if (carParkingPlaces[i] != null) {
                carParking.append(carParkingPlaces[i].toString());
            }
        }

        StringBuilder truckParking = new StringBuilder();
        Vehicle[] truckParkingPlaces = parkingControl.getTruckParking().getParkingPlaces();
        for (int i = 0; i < truckParkingPlaces.length; i++) {
            if (truckParkingPlaces[i] != null) {
                truckParking.append(truckParkingPlaces[i].toString());
            }
        }

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0)).append(vehicles.get(2)).append(vehicles.get(2));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));
    }

    /**
     * When No Place In ParkingTruck And No Place In CarParking For Tracks but try to put a Truck.
     */
    @Test
    public void whenNoPlaceInTruckParkingAndNoPlaceInCarParkingForTracksAddTruck() {

        ParkingControl parkingControl = new ParkingControl(3, 1);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ", 3),
                new Truck("MAZ", 3));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        Vehicle[] carParkingPlaces = parkingControl.getCarParking().getParkingPlaces();
        for (int i = 0; i < carParkingPlaces.length; i++) {
            if (carParkingPlaces[i] != null) {
                carParking.append(carParkingPlaces[i].toString());
            }
        }

        StringBuilder truckParking = new StringBuilder();
        Vehicle[] truckParkingPlaces = parkingControl.getTruckParking().getParkingPlaces();
        for (int i = 0; i < truckParkingPlaces.length; i++) {
            if (truckParkingPlaces[i] != null) {
                truckParking.append(truckParkingPlaces[i].toString());
            }
        }

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));
        assertThat(parkingControl.distribute(vehicles.get(2)), is(false));
    }

    /**
     * When No Place In CarParking but try to put a car.
     */
    @Test
    public void whenNoPlaceInCarParkingAddCar() {

        ParkingControl parkingControl = new ParkingControl(1, 3);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Truck("KAMAZ", 3));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        Vehicle[] carParkingPlaces = parkingControl.getCarParking().getParkingPlaces();
        for (int i = 0; i < carParkingPlaces.length; i++) {
            if (carParkingPlaces[i] != null) {
                carParking.append(carParkingPlaces[i].toString());
            }
        }

        StringBuilder truckParking = new StringBuilder();
        Vehicle[] truckParkingPlaces = parkingControl.getTruckParking().getParkingPlaces();
        for (int i = 0; i < truckParkingPlaces.length; i++) {
            if (truckParkingPlaces[i] != null) {
                truckParking.append(truckParkingPlaces[i].toString());
            }
        }

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(1));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));

        Vehicle car = new Car("MINI");

        parkingControl.distribute(car);
    }

    /**
     * When there are places but not nearby whenThereArePlacesButNotNearby
     */
    @Test
    public void whenThereArePlacesButNotNearby() {

        ParkingControl parkingControl = new ParkingControl(4, 1);

        List<Vehicle> vehicles = List.of(
                new Car("KIA"),
                new Car("BMW"),
                new Car("MINI"),
                new Truck("KAMAZ", 3));

        vehicles.forEach(parkingControl::distribute);

        StringBuilder carParking = new StringBuilder();
        Vehicle[] carParkingPlaces = parkingControl.getCarParking().getParkingPlaces();
        for (int i = 0; i < carParkingPlaces.length; i++) {
            if (carParkingPlaces[i] != null) {
                carParking.append(carParkingPlaces[i].toString());
            }
        }

        StringBuilder truckParking = new StringBuilder();
        Vehicle[] truckParkingPlaces = parkingControl.getTruckParking().getParkingPlaces();
        for (int i = 0; i < truckParkingPlaces.length; i++) {
            if (truckParkingPlaces[i] != null) {
                truckParking.append(truckParkingPlaces[i].toString());
            }
        }

        StringBuilder resultCar = new StringBuilder();
        resultCar.append(vehicles.get(0)).append(vehicles.get(1)).append(vehicles.get(2));

        StringBuilder resultTruck = new StringBuilder();
        resultTruck.append(vehicles.get(3));

        assertThat(carParking.toString(), is(resultCar.toString()));
        assertThat(truckParking.toString(), is(resultTruck.toString()));

        assertThat(parkingControl.leaveParking(vehicles.get(1)), is(true));

        StringBuilder resultCarAfterLeaving = new StringBuilder();
        resultCarAfterLeaving.append(vehicles.get(0)).append("null").append(vehicles.get(2)).append("null");

        StringBuilder carParkingAfterLeaving = new StringBuilder();
        Vehicle[] carParkingPlacesAfterLeaving = parkingControl.getCarParking().getParkingPlaces();
        for (int i = 0; i < carParkingPlacesAfterLeaving.length; i++) {
            if (carParkingPlacesAfterLeaving[i] != null) {
                carParkingAfterLeaving.append(carParkingPlacesAfterLeaving[i].toString());
            } else {
                carParkingAfterLeaving.append("null");
            }
        }

        assertThat(carParkingAfterLeaving.toString(), is(resultCarAfterLeaving.toString()));

        Vehicle maz = new Truck("MAZ", 2);
        assertThat(parkingControl.distribute(maz), is(false));
    }
}
