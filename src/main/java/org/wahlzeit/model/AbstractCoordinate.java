package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    private static final double PRECISION_EPSILON = 1e-5;

    public abstract CartesianCoordinate asCartesianCoordinate() throws IllegalStateException;
    public abstract SphericCoordinate asSphericCoordinate() throws IllegalStateException;

    @Override
    public double getCartesianDistance(Coordinate c) throws IllegalStateException {
        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cartesiancoord = c.asCartesianCoordinate();

        thisAsCartesian.assertClassInvariants();
        cartesiancoord.assertClassInvariants();

        double sum = Math.pow(thisAsCartesian.getX() - cartesiancoord.getX(), 2)
                    + Math.pow(thisAsCartesian.getY() - cartesiancoord.getY(), 2)
                    + Math.pow(thisAsCartesian.getZ() - cartesiancoord.getZ(), 2);
        return Math.sqrt(sum);
    }

    @Override
    public double getCentralAngle(Coordinate c) throws IllegalStateException {
        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cartesiancoord = c.asCartesianCoordinate();

        thisAsCartesian.assertClassInvariants();
        cartesiancoord.assertClassInvariants();

        double dist = thisAsCartesian.getCartesianDistance(cartesiancoord);
	    // https://en.wikipedia.org/wiki/Great-circle_distance#From_chord_length
        return Math.asin(dist / 2) * 2;
    }

    @Override
    public boolean isEqual(Coordinate c) throws IllegalStateException {
        if (c == this) {
            return true;
        }

        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = c.asCartesianCoordinate();

        thisAsCartesian.assertClassInvariants();
        cartesianCoordinate.assertClassInvariants();

        boolean allCoordEqual = Math.abs(thisAsCartesian.getX() - cartesianCoordinate.getX()) < PRECISION_EPSILON &&
                                Math.abs(thisAsCartesian.getY() - cartesianCoordinate.getY()) < PRECISION_EPSILON &&
                                Math.abs(thisAsCartesian.getZ() - cartesianCoordinate.getZ()) < PRECISION_EPSILON;
        return allCoordEqual;
    }

    @Override
    public boolean equals(Object object) throws IllegalStateException {
        if (object instanceof Coordinate) {
            return isEqual((Coordinate) object);
        }
        return false;
    }
}
