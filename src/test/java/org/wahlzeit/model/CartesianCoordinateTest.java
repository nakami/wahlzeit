package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CartesianCoordinateTest {

    @Test
    public void testGetDistanceSameCoordVec() {
        CartesianCoordinate a = new CartesianCoordinate(1.0, 1.0, 1.0);
        CartesianCoordinate b = new CartesianCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.getDistance(b) == 0.0);
    }

    @Test
    public void testGetDistanceSameCoordObj() {
        CartesianCoordinate a = new CartesianCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.getDistance(a) == 0.0);
    }

    @Test
    public void testGetDistanceOneAxisDiffer() {
        CartesianCoordinate a = new CartesianCoordinate(1.0, 1.0, 1.0);
        CartesianCoordinate b = new CartesianCoordinate(2.0, 1.0, 1.0);
        assertTrue(a.getDistance(b) == 1.0);
        assertTrue(b.getDistance(a) == 1.0);

        a = new CartesianCoordinate(1.0, 1.0, 1.0);
        b = new CartesianCoordinate(1.0, 2.0, 1.0);
        assertTrue(a.getDistance(b) == 1.0);
        assertTrue(b.getDistance(a) == 1.0);

        a = new CartesianCoordinate(1.0, 1.0, 1.0);
        b = new CartesianCoordinate(1.0, 1.0, 2.0);
        assertTrue(a.getDistance(b) == 1.0);
        assertTrue(b.getDistance(a) == 1.0);
    }

    @Test
    public void testIsEqualSimple() {
        CartesianCoordinate a = new CartesianCoordinate(1.0, 1.0, 1.0);
        CartesianCoordinate b = new CartesianCoordinate(1.0, 1.0, 1.0);
        assertTrue(a.isEqual(b));

        a = new CartesianCoordinate(1.0, 1.0, 1.0);
        b = new CartesianCoordinate(2.0, 1.0, 1.0);
        assertFalse(a.isEqual(b));
    }

    @Test
    public void testInterpretAsCartesian() {
        CartesianCoordinate coord = new CartesianCoordinate(1.0, 1.0, 1.0);
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
        CartesianCoordinate cartesiancoord0 = new CartesianCoordinate(1.0, 1.0, 1.0);
        CartesianCoordinate cartesiancoord1 = new CartesianCoordinate(1.0, 1.0, 1.0);
        SphericCoordinate sphericcoord0 = cartesiancoord0.asSphericCoordinate();
        SphericCoordinate sphericcoord1 = cartesiancoord1.asSphericCoordinate();
        assertTrue(sphericcoord0.equals(sphericcoord1));
        assertTrue(sphericcoord0.equals(sphericcoord1));

        CartesianCoordinate cartesiancoord2 = new CartesianCoordinate(1.0, 1.0, 1.0);
        CartesianCoordinate cartesiancoord3 = new CartesianCoordinate(2.0, 1.0, 1.0);
        SphericCoordinate sphericcoord2 = cartesiancoord2.asSphericCoordinate();
        SphericCoordinate sphericcoord3 = cartesiancoord3.asSphericCoordinate();
        assertFalse(sphericcoord2.equals(sphericcoord3));
    }

}