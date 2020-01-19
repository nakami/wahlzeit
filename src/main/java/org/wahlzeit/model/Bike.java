package org.wahlzeit.model;

public class Bike {

    private BikeType bikeType = null;

    public Bike(BikeType biketype) {
        this.bikeType = biketype;
    }

    public BikeType getType() {
        return this.bikeType;
    }

    public void setType(BikeType biketype) {
        this.bikeType = biketype;
    }
}