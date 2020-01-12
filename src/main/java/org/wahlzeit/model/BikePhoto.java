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

    public BikePhoto(PhotoId myId, BikeType biketype) {
        super(myId);
        this.biketype = biketype;
    }

    public BikeType getBikeType() {
        return this.biketype;
    }

    public void setBikeType(BikeType biketype) {
        this.biketype = biketype;
    }

    public boolean hasSameOwner(BikePhoto photo) {
		return photo.getOwnerEmailAddress().equals(ownerEmailAddress);
	}
}