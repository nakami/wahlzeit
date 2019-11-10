package org.wahlzeit.model;

public class BikePhoto extends Photo {

    private BikeType biketype;

    public BikePhoto(){
        super();
        this.biketype = BikeType.UNKNOWN;
    }

    public BikePhoto(BikeType biketype) {
        super();
        this.biketype = biketype;
    }

    public BikePhoto(PhotoId myId){
        super(myId);
    }

    public BikeType getBikeType() {
        return this.biketype;
    }

    public void setBikeType(BikeType biketype) {
        this.biketype = biketype;
    }
}