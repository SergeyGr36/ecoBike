package com.sergey.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class Speedelec extends Bike {
    private int maximumSpeed;
    private int batteryCapacity;

    public Speedelec() {
    }

    public Speedelec(String brand, int maximumSpeed, int weight,
                     boolean lightAvailability, int batteryCapacity, String color, BigDecimal price) {
        super(brand, weight, lightAvailability, color, price);
        this.maximumSpeed = maximumSpeed;
        this.batteryCapacity = batteryCapacity;
    }

    private Speedelec(String[] objects) {
        super.setBrand(objects[0]);
        maximumSpeed = Integer.parseInt(objects[1]);
        super.setWeight(Integer.parseInt(objects[2]));
        super.setLightAvailability(Boolean.parseBoolean(objects[3].toLowerCase()));
        batteryCapacity = Integer.parseInt(objects[4]);
        super.setColor(objects[5]);
        super.setPrice(new BigDecimal(Integer.parseInt(objects[6])));
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
        Speedelec speedelec = (Speedelec) o;
        return maximumSpeed == speedelec.maximumSpeed &&
                batteryCapacity == speedelec.batteryCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maximumSpeed, batteryCapacity);
    }

    @Override
    public String toString() {
        return "SPEEDELEC " + super.getBrand() +
                "; " + maximumSpeed +
                "; " + super.getWeight() +
                "; " + String.valueOf(super.isLightAvailability()).toUpperCase() +
                "; " + batteryCapacity +
                "; " + super.getColor().toLowerCase() +
                "; " + super.getPrice()+"\n";
    }
}
