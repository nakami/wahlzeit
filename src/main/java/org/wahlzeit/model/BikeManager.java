package org.wahlzeit.model;

import java.util.HashMap;
import java.util.HashSet;

public class BikeManager {

    private static BikeManager instance = new BikeManager();
    private HashSet<Bike> bikes = new HashSet<Bike>();
    private HashMap<String, BikeType> bikeTypes = new HashMap<String, BikeType>();

    public static BikeManager getInstance() {
        return instance;
    }

    public Bike createBike(String typeName) {
        assertIsValidBikeTypeName(typeName);
        BikeType bt = getOrCreateBikeType(typeName);
        Bike result = bt.createInstance();
        bikes.add(result);
        return result;
    }

    public BikeType getOrCreateBikeType(String typeName) {
        assertIsValidBikeTypeName(typeName);
        BikeType bt = bikeTypes.get(typeName);
        if (bt == null) {
            BikeType btnew = new BikeType(typeName);
            bikeTypes.put(typeName, btnew);
            return btnew;
        } else {
            return bt;
        }
    }

    private void assertIsValidBikeTypeName(String typeName) {
        assert(typeName != null);
        assert(typeName != "");
    }
}