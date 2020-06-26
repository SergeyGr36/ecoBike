package com.sergey.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class Folding extends Bike {
    private int wheelSize;
    private int gearsCount;

    public Folding() {
    }

    public Folding(String brand, int wheelSize, int gearsCount, int weight,
                   boolean lightAvailability, String color, BigDecimal price) {
        super(brand, weight, lightAvailability, color, price);
        this.wheelSize = wheelSize;
        this.gearsCount = gearsCount;
    }

    //   todo Через жопу. Переробить як знайду рішення
    private Folding(String[] objects) {
        super.setBrand(objects[0]);
        wheelSize = Integer.parseInt(objects[1]);
        gearsCount = Integer.parseInt(objects[2]);
        super.setWeight(Integer.parseInt(objects[3]));
        super.setLightAvailability(Boolean.parseBoolean(objects[4].toLowerCase()));
        super.setColor(objects[5]);
        super.setPrice(new BigDecimal(Integer.parseInt(objects[6])));
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getGearsCount() {
        return gearsCount;
    }

    public void setGearsCount(int gearsCount) {
        this.gearsCount = gearsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folding folding = (Folding) o;
        return wheelSize == folding.wheelSize &&
                gearsCount == folding.gearsCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheelSize, gearsCount);
    }

    @Override
    public String toString() {
        return "FOLDING BIKE " + super.getBrand() +
                "; " + wheelSize +
                "; " + gearsCount +
                "; " + super.getWeight() +
                "; " + String.valueOf(super.isLightAvailability()).toUpperCase() +
                "; " + super.getColor().toLowerCase() +
                "; " + super.getPrice()+"\n";
    }
}
