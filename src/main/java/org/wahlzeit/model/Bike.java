package org.wahlzeit.model;

public class Bike {

    private BikeType bikeType = null;

    public Bike(BikeType bt) {
        bikeType = bt;
    }

    public BikeType getType() {
        return bikeType;
    }

    public void setType(BikeType bt) {
        this.bikeType = bt;
    }
}