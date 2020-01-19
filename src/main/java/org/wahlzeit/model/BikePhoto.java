package org.wahlzeit.model;

import org.wahlzeit.annotations.PatternInstance;

// https://en.wikipedia.org/wiki/Abstract_factory_pattern
@PatternInstance(
    patternName = "Abstract Factory",
    participants = {
        "Product"
    }
)

public class BikePhoto extends Photo {

    private Bike myBike;

    public BikePhoto(){
        super();
    }

    public Bike getBike() {
        return this.myBike;
    }

    public void setBike(Bike bike) throws IllegalArgumentException {
        if(bike == null) {
            throw new IllegalArgumentException("The bike may not be set to null");
        } else {
            this.myBike = bike;
        }
    }

    public BikePhoto(PhotoId myId){
        super(myId);
    }

    public boolean hasSameOwner(BikePhoto photo) {
        return photo.getOwnerEmailAddress().equals(ownerEmailAddress);
    }
}