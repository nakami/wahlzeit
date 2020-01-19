package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BikeManagerTest {
    private BikeManager manager = BikeManager.getInstance();
    
    @Test
    public void testSingleton() {
        assertEquals(BikeManager.getInstance(), manager);
    }

    @Test
    public void testAssertIsValidBikeTypeNameOK() {
        Bike bike = manager.createBike("somebiketype");
    }

    @Test(expected = AssertionError.class)
    public void testAssertIsValidBikeTypeNameNotOK1() {
        Bike bike = manager.createBike("");
    }

    @Test(expected = AssertionError.class)
    public void testAssertIsValidBikeTypeNameNotOK2() {
        Bike bike = manager.createBike(null);
    }

    @Test
    public void testGetOrCreateBikeType() {
        BikeType bikeType = manager.getOrCreateBikeType("somebiketype");
        assertNotEquals(bikeType, null);
    }
    
}
