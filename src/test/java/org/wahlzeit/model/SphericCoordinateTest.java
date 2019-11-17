package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest {

    @Test
    public void getDistanceSameCoordVec() {
        SphericCoordinate a = new SphericCoordinate(1.0, 1.0, 1.0);
        SphericCoordinate b = new SphericCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.getDistance(b) == 0.0);
    }

    @Test
    public void getDistanceSameCoordObj() {
        SphericCoordinate a = new SphericCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.getDistance(a) == 0.0);
    }

    @Test
    public void isEqualSimple() {
        SphericCoordinate a = new SphericCoordinate(1.0, 1.0, 1.0);
        SphericCoordinate b = new SphericCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.isEqual(b));

        a = new SphericCoordinate(1.0, 1.0, 1.0);
        b = new SphericCoordinate(2.0, 1.0, 1.0);
        assertFalse(a.isEqual(b));
    }

    @Test
    public void testGetDistanceWhileCartesianOneAxisDiffer() {
        SphericCoordinate a = (new CartesianCoordinate(1.0, 1.0, 1.0)).asSphericCoordinate();
        SphericCoordinate b = (new CartesianCoordinate(2.0, 1.0, 1.0)).asSphericCoordinate();
        assertEquals(a.getDistance(b), 1.0, 0.001);
        assertEquals(b.getDistance(a), 1.0, 0.001);

        a = (new CartesianCoordinate(1.0, 1.0, 1.0)).asSphericCoordinate();
        b = (new CartesianCoordinate(1.0, 2.0, 1.0)).asSphericCoordinate();
        assertEquals(a.getDistance(b), 1.0, 0.001);
        assertEquals(b.getDistance(a), 1.0, 0.001);

        a = (new CartesianCoordinate(1.0, 1.0, 1.0)).asSphericCoordinate();
        b = (new CartesianCoordinate(1.0, 1.0, 2.0)).asSphericCoordinate();
        assertEquals(a.getDistance(b), 1.0, 0.001);
        assertEquals(b.getDistance(a), 1.0, 0.001);
    }
}