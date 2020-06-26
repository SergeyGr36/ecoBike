package com.sergey.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class EBike extends Bike {
    private int maximumSpeed;
    private int batteryCapacity;

    public EBike() {

    }

    public EBike(String brand, int maximumSpeed, int weight,
                 boolean lightAvailability, int batteryCapacity, String color, BigDecimal price) {
        super(brand, weight, lightAvailability, color, price);
        this.maximumSpeed = maximumSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    private EBike(String[] objects) {
        super.setBrand(objects[0]);
//        todo check it. If works fine, let it been
        maximumSpeed = objects[1]==null? 0:Integer.parseInt(objects[1]);
        super.setWeight(objects[2]==null?0:Integer.parseInt(objects[2]));
        super.setLightAvailability(Boolean.parseBoolean(objects[3].toLowerCase()));
        batteryCapacity = objects[4]==null? 0:Integer.parseInt(objects[4]);
        super.setColor(objects[5]);
        super.setPrice(new BigDecimal(objects[6]==null?0:Integer.parseInt(objects[6])));
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EBike eBike = (EBike) o;
        return maximumSpeed == eBike.maximumSpeed &&
                batteryCapacity == eBike.batteryCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maximumSpeed, batteryCapacity);
    }

    @Override
    public String toString() {
        return "E-BIKE " + super.getBrand() +
                "; " + maximumSpeed +
                "; " + super.getWeight() +
                "; " + String.valueOf(super.isLightAvailability()).toUpperCase() +
                "; " + batteryCapacity +
                "; " + super.getColor().toLowerCase() +
                "; " + super.getPrice()+"\n";
    }
}
