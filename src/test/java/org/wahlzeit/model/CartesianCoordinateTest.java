package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CartesianCoordinateTest {

    @Test
    public void testGetCartesianDistanceSameCoordVec() {
        CartesianCoordinate a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        CartesianCoordinate b = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        assertTrue(a.getCartesianDistance(b) == 0.0);
    }

    @Test
    public void testGetCartesianDistanceSameCoordObj() {
        CartesianCoordinate a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        assertTrue(a.getCartesianDistance(a) == 0.0);
    }

    @Test
    public void testGetCartesianDistanceOneAxisDiffer() {
        CartesianCoordinate a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        CartesianCoordinate b = CartesianCoordinate.createOrGetByComponents(2.0, 1.0, 1.0);
        assertTrue(a.getCartesianDistance(b) == 1.0);
        assertTrue(b.getCartesianDistance(a) == 1.0);

        a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        b = CartesianCoordinate.createOrGetByComponents(1.0, 2.0, 1.0);
        assertTrue(a.getCartesianDistance(b) == 1.0);
        assertTrue(b.getCartesianDistance(a) == 1.0);

        a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        b = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 2.0);
        assertTrue(a.getCartesianDistance(b) == 1.0);
        assertTrue(b.getCartesianDistance(a) == 1.0);
    }

    @Test
    public void testIsEqualSimple() {
        CartesianCoordinate a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        CartesianCoordinate b = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        assertTrue(a.isEqual(b));

        a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        b = CartesianCoordinate.createOrGetByComponents(2.0, 1.0, 1.0);
        assertFalse(a.isEqual(b));
    }

    @Test
    public void testIsEqualOperator() {
        CartesianCoordinate a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        CartesianCoordinate b = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        assertTrue(a == b);

        a = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        b = CartesianCoordinate.createOrGetByComponents(2.0, 1.0, 1.0);
        assertFalse(a == b);
    }

    @Test
    public void testInterpretAsCartesian() {
        CartesianCoordinate coord = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        CartesianCoordinate coordAsCartesian = coord.asCartesianCoordinate();
        CartesianCoordinate coordAsSphericAsCartesian = coord.asSphericCoordinate().asCartesianCoordinate();

        assertTrue(coord.equals(coord));

        assertTrue(coord.isEqual(coordAsCartesian));
        assertTrue(coord.equals(coordAsCartesian));

        assertTrue(coord.isEqual(coordAsSphericAsCartesian));
        assertTrue(coord.equals(coordAsSphericAsCartesian));

        assertTrue(coordAsCartesian.isEqual(coordAsSphericAsCartesian));
        assertTrue(coordAsCartesian.equals(coordAsSphericAsCartesian));

        assertTrue(coordAsSphericAsCartesian.isEqual(coordAsCartesian));
        assertTrue(coordAsSphericAsCartesian.equals(coordAsCartesian));
    }

    @Test
    public void testInterpretAsSpheric() {
        CartesianCoordinate cartesiancoord0 = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        CartesianCoordinate cartesiancoord1 = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        SphericCoordinate sphericcoord0 = cartesiancoord0.asSphericCoordinate();
        SphericCoordinate sphericcoord1 = cartesiancoord1.asSphericCoordinate();
        assertTrue(sphericcoord0.equals(sphericcoord1));
        assertTrue(sphericcoord0.equals(sphericcoord1));

        CartesianCoordinate cartesiancoord2 = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        CartesianCoordinate cartesiancoord3 = CartesianCoordinate.createOrGetByComponents(2.0, 1.0, 1.0);
        SphericCoordinate sphericcoord2 = cartesiancoord2.asSphericCoordinate();
        SphericCoordinate sphericcoord3 = cartesiancoord3.asSphericCoordinate();
        assertFalse(sphericcoord2.equals(sphericcoord3));
    }


    @Test(expected = IllegalStateException.class)
    public void testConstructorIllegalState() {
        CartesianCoordinate coord = CartesianCoordinate.createOrGetByComponents(Double.POSITIVE_INFINITY, 0.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetXIllegalArgument() {
        CartesianCoordinate coord = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        coord = coord.setXAndReturn(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetYIllegalArgument() {
        CartesianCoordinate coord = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        coord = coord.setYAndReturn(Double.POSITIVE_INFINITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetZIllegalArgument() {
        CartesianCoordinate coord = CartesianCoordinate.createOrGetByComponents(1.0, 1.0, 1.0);
        coord = coord.setZAndReturn(Double.POSITIVE_INFINITY);
    }

    @Test
    public void testSettersAndGetters() {
        CartesianCoordinate coord = CartesianCoordinate.createOrGetByComponents(1.0, 2.0, 3.0);
        assertTrue(coord.getX() == 1.0);
        assertTrue(coord.getY() == 2.0);
        assertTrue(coord.getZ() == 3.0);
        coord = coord.setXAndReturn(4.0);
        assertTrue(coord.getX() == 4.0);
        coord = coord.setYAndReturn(5.0);
        assertTrue(coord.getY() == 5.0);
        coord = coord.setZAndReturn(6.0);
        assertTrue(coord.getZ() == 6.0);
    }
}