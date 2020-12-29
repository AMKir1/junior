package ru.job4j.parking;
/*
 * Chapter_009. OOD [#143]
 * Task: 2. Парковка машин [#853]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
/**
 * Vehicle class.
 */
public class Vehicle {

    /**
     * Vehicle's name.
     */
    private String name;
    /**
     * Vehicle's size for parking.
     */
    private int size;

    /**
     * Designer.
     * @param name - vehicle's name.
     * @param size - vehicle's size for parking.
     */
    public Vehicle(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
