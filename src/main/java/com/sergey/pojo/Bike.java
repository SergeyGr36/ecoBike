package com.sergey.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class Bike {
        private String brand;
        private int weight;
        private boolean lightAvailability;
        private String color;
        private BigDecimal price;

        public Bike() {
        }

        public Bike(String brand, int weight, boolean lightAvailability, String color, BigDecimal price) {
            this.brand = brand;
            this.weight = weight;
            this.lightAvailability = lightAvailability;
            this.color = color;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public boolean isLightAvailability() {
            return lightAvailability;
        }

        public void setLightAvailability(boolean lightAvailability) {
            this.lightAvailability = lightAvailability;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bike bike = (Bike) o;
            return weight == bike.weight &&
                    lightAvailability == bike.lightAvailability &&
                    Objects.equals(brand, bike.brand) &&
                    Objects.equals(color, bike.color) &&
                    Objects.equals(price, bike.price);
        }

        @Override
        public int hashCode() {
            return Objects.hash(brand, weight, lightAvailability, color, price);
        }
}
