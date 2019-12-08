package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest {

    @Test
    public void testGetCartesianDistanceSameCoordVec() {
        SphericCoordinate a = new SphericCoordinate(1.0, 1.0, 1.0);
        SphericCoordinate b = new SphericCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.getCartesianDistance(b) == 0.0);
    }

    @Test
    public void testGetCartesianDistanceSameCoordObj() {
        SphericCoordinate a = new SphericCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.getCartesianDistance(a) == 0.0);
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
    public void testGetCartesianDistanceWhileCartesianOneAxisDiffer() {
        SphericCoordinate a = (new CartesianCoordinate(1.0, 1.0, 1.0)).asSphericCoordinate();
        SphericCoordinate b = (new CartesianCoordinate(2.0, 1.0, 1.0)).asSphericCoordinate();
        assertEquals(a.getCartesianDistance(b), 1.0, 0.001);
        assertEquals(b.getCartesianDistance(a), 1.0, 0.001);

        a = (new CartesianCoordinate(1.0, 1.0, 1.0)).asSphericCoordinate();
        b = (new CartesianCoordinate(1.0, 2.0, 1.0)).asSphericCoordinate();
        assertEquals(a.getCartesianDistance(b), 1.0, 0.001);
        assertEquals(b.getCartesianDistance(a), 1.0, 0.001);

        a = (new CartesianCoordinate(1.0, 1.0, 1.0)).asSphericCoordinate();
        b = (new CartesianCoordinate(1.0, 1.0, 2.0)).asSphericCoordinate();
        assertEquals(a.getCartesianDistance(b), 1.0, 0.001);
        assertEquals(b.getCartesianDistance(a), 1.0, 0.001);
    }


    @Test(expected = IllegalStateException.class)
    public void testConstructorIllegalState() {
        SphericCoordinate coord = new SphericCoordinate(Double.POSITIVE_INFINITY, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhiIllegalArgument() {
        SphericCoordinate coord = new SphericCoordinate(1.0, 1.0, 1.0);
        coord.setPhi(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThetaIllegalArgument() {
        SphericCoordinate coord = new SphericCoordinate(1.0, 1.0, 1.0);
        coord.setTheta(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusIllegalArgument() {
        SphericCoordinate coord = new SphericCoordinate(1.0, 1.0, 1.0);
        coord.setRadius(Double.POSITIVE_INFINITY);
    }
}