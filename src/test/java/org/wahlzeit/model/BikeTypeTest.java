package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BikeTypeTest {
	@Test
    public void testSubtypeSupertype() {
        BikeType city = new BikeType("CITYRAD");
        BikeType damen = new BikeType("DAMENRAD");
        BikeType holland = new BikeType("HOLLANDRAD");

        city.addSubType(damen);
        
        assertTrue(damen.isSubtypeOf(city));
        assertTrue(city.isSupertypeOf(damen));
        
        damen.addSubType(holland);

        assertTrue(holland.isSubtypeOf(damen));
        assertTrue(damen.isSupertypeOf(holland));
    }
}
