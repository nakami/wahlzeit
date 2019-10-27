package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CoordinateTest {

    @Test
    public void getDistanceSameCoordVec() {
        Coordinate a = new Coordinate(1.0, 1.0, 1.0);
        Coordinate b = new Coordinate(1.0, 1.0, 1.0);
        assertTrue(a.getDistance(b) == 0.0);
    }

    @Test
    public void getDistanceSameCoordObj() {
        Coordinate a = new Coordinate(1.0, 1.0, 1.0);
        assertTrue(a.getDistance(a) == 0.0);
    }

    @Test
    public void getDistanceOneAxisDiffer() {
        Coordinate a = new Coordinate(1.0, 1.0, 1.0);
        Coordinate b = new Coordinate(2.0, 1.0, 1.0);
        assertTrue(a.getDistance(b) == 1.0);
        assertTrue(b.getDistance(a) == 1.0);

        a = new Coordinate(1.0, 1.0, 1.0);
        b = new Coordinate(1.0, 2.0, 1.0);
        assertTrue(a.getDistance(b) == 1.0);
        assertTrue(b.getDistance(a) == 1.0);

        a = new Coordinate(1.0, 1.0, 1.0);
        b = new Coordinate(1.0, 1.0, 2.0);
        assertTrue(a.getDistance(b) == 1.0);
        assertTrue(b.getDistance(a) == 1.0);
    }

    @Test
    public void isEqualSimple() {
        Coordinate a = new Coordinate(1.0, 1.0, 1.0);
        Coordinate b = new Coordinate(1.0, 1.0, 1.0);
        assertTrue(a.isEqual(b));

        a = new Coordinate(1.0, 1.0, 1.0);
        b = new Coordinate(2.0, 1.0, 1.0);
        assertFalse(a.isEqual(b));
    }
}