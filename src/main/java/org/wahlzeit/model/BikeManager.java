package org.wahlzeit.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class BikeManager {

    public String[] bikeTypeNames = {
        null,
        "CITYBIKE",
        "RACINGBIKE",
        "MOUNTAINBIKE",
        "MISCELLANEOUS",
        "UNKNOWN"
    };

    private static BikeManager instance = new BikeManager();
    private final HashSet<Bike> bikes = new HashSet<Bike>();
    private final HashMap<String, BikeType> bikeTypes = new HashMap<String, BikeType>();

    public static BikeManager getInstance() {
        return instance;
    }

    public Bike createBike(String typeName) {
        assertIsValidBikeTypeName(typeName);
        BikeType bt = getBikeType(typeName);
        Bike result = bt.createInstance();
        bikes.add(result);
        return result;
       }

    private BikeType getBikeType(String typeName) {
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
        assert(Arrays.asList(bikeTypeNames).contains(typeName));
    }
}