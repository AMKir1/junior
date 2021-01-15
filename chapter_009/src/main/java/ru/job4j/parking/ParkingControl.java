package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 3
 */

import java.util.stream.IntStream;

/**
 * Parking Control class.
 */
public class ParkingControl {

    private final Parking carParking;
    private final Parking truckParking;

    public ParkingControl(int sizeCar, int sizeTruck) {
        this.carParking = new ParkingCar(sizeCar);
        this.truckParking = new ParkingTruck(sizeTruck);
    }

    public boolean distribute(Vehicle vehicle) {
        return vehicle.getSize() > 1
                ? parkingToOwnParkingLot(truckParking, vehicle)
                || parkingToAnotherParkingLot(carParking, vehicle)
                : parkingToOwnParkingLot(carParking, vehicle);
    }

    public Parking getCarParking() {
        return this.carParking;
    }

    public Parking getTruckParking() {
        return this.truckParking;
    }

    private boolean parkingToAnotherParkingLot(Parking parking, Vehicle vehicle) {
        if (parking.size() != 0) {
            int place = getFreeParkingPlaces(parking.getParkingPlaces(), vehicle.getSize());
            if (place != -1) {
                int allPartsOfPlace = place + vehicle.getSize();
                while (place < allPartsOfPlace) {
                    parking.add(place, vehicle);
                    place++;
                }
                return true;
            }
        }
        return false;
    }

    private boolean parkingToOwnParkingLot(Parking parking, Vehicle vehicle) {
        if (parking.size() != 0) {
            int freePlace = getFreeParkingPlace(parking.getParkingPlaces());
            if (freePlace != -1) {
                parking.add(freePlace, vehicle);
                return true;
            }
        }
        return false;
    }

    private int getFreeParkingPlaces(Vehicle[] parking, int vehicleSize) {
        int counter = 0;
        for (int i = 0; i < parking.length - vehicleSize; i++) {
            if (parking[i] == null) {
                int j = i;
                while (counter < vehicleSize) {
                    if (parking[j] == null) {
                        j++;
                        counter++;
                    } else {
                        break;
                    }
                }
                if (counter == vehicleSize) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getFreeParkingPlace(Vehicle[] parking) {
        return IntStream.range(0, parking.length).filter(i -> parking[i] == null).findFirst().orElse(-1);
    }

    public boolean leaveParking(Vehicle vehicle) {
        boolean leave;
        if (vehicle.getSize() > 1) {
            leave = clearCarFromParkingLot(getTruckParking().getParkingPlaces(), vehicle);
            if (!leave) {
                leave = clearCarFromParkingLot(getCarParking().getParkingPlaces(), vehicle);
            }
            return leave;
        } else {
            leave = clearCarFromParkingLot(getCarParking().getParkingPlaces(), vehicle);
        }
        return leave;
    }

    private boolean clearCarFromParkingLot(Vehicle[] parking, Vehicle vehicle) {
        boolean result = false;
        for (int i = 0; i < parking.length; i++) {
            if (parking[i] != null) {
                if (parking[i].equals(vehicle)) {
                    parking[i] = null;
                    result = true;
                }
            }
        }
        return result;
    }
}
