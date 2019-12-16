package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class SphericCoordinateTest {

    @Test
    public void testGetCartesianDistanceSameCoordVec() {
        SphericCoordinate a = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        SphericCoordinate b = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        assertTrue(a.getCartesianDistance(b) == 0.0);
    }

    @Test
    public void testGetCartesianDistanceSameCoordObj() {
        SphericCoordinate a = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        assertTrue(a.getCartesianDistance(a) == 0.0);
    }

    @Test
    public void isEqualSimple() {
        SphericCoordinate a = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        SphericCoordinate b = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        assertTrue(a.isEqual(b));

        a = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        b = SphericCoordinate.createOrGetByComponents(2.0, 1.0, 1.0);
        assertFalse(a.isEqual(b));
    }

    @Test
    public void testGetCartesianDistanceWhileCartesianOneAxisDiffer() {
        SphericCoordinate a = (CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0)).asSphericCoordinate();
        SphericCoordinate b = (CartesianCoordinate.createOrGetByComponents(2.0, 1.0, 1.0)).asSphericCoordinate();
        assertEquals(a.getCartesianDistance(b), 1.0, 0.001);
        assertEquals(b.getCartesianDistance(a), 1.0, 0.001);

        a = (CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0)).asSphericCoordinate();
        b = (CartesianCoordinate.createOrGetByComponents(1.0, 2.0, 1.0)).asSphericCoordinate();
        assertEquals(a.getCartesianDistance(b), 1.0, 0.001);
        assertEquals(b.getCartesianDistance(a), 1.0, 0.001);

        a = (CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0)).asSphericCoordinate();
        b = (CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 2.0)).asSphericCoordinate();
        assertEquals(a.getCartesianDistance(b), 1.0, 0.001);
        assertEquals(b.getCartesianDistance(a), 1.0, 0.001);
    }


    @Test(expected = IllegalStateException.class)
    public void testConstructorIllegalState() {
        SphericCoordinate coord = SphericCoordinate.createOrGetByComponents(Double.POSITIVE_INFINITY, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPhiIllegalArgument() {
        SphericCoordinate coord = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        coord = coord.setPhiAndReturn(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThetaIllegalArgument() {
        SphericCoordinate coord = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        coord = coord.setThetaAndReturn(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetRadiusIllegalArgument() {
        SphericCoordinate coord = SphericCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        coord = coord.setRadiusAndReturn(Double.POSITIVE_INFINITY);
    }

    @Test
    public void testSettersAndGetters() {
        SphericCoordinate coord = SphericCoordinate.createOrGetByComponents(1.0, 2.0, 3.0);
        assertTrue(coord.getPhi() == 1.0);
        assertTrue(coord.getTheta() == 2.0);
        assertTrue(coord.getRadius() == 3.0);
        coord = coord.setPhiAndReturn(4.0);
        assertTrue(coord.getPhi() == 4.0);
        coord = coord.setThetaAndReturn(5.0);
        assertTrue(coord.getTheta() == 5.0);
        coord = coord.setRadiusAndReturn(6.0);
        assertTrue(coord.getRadius() == 6.0);
    }
}