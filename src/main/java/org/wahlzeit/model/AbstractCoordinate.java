package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
    private static final double PRECISION_EPSILON = 1e-5;

    public abstract CartesianCoordinate asCartesianCoordinate();
    public abstract SphericCoordinate asSphericCoordinate();

    @Override
    public double getCartesianDistance(Coordinate c) {
        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cartesiancoord = c.asCartesianCoordinate();

        double sum = Math.pow(thisAsCartesian.getX() - cartesiancoord.getX(), 2)
                    + Math.pow(thisAsCartesian.getY() - cartesiancoord.getY(), 2)
                    + Math.pow(thisAsCartesian.getZ() - cartesiancoord.getZ(), 2);
        return Math.sqrt(sum);
    }

    @Override
    public double getCentralAngle(Coordinate c) {
        CartesianCoordinate cartesiancoord = c.asCartesianCoordinate();
        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        double dist = thisAsCartesian.getCartesianDistance(cartesiancoord);
	    // https://en.wikipedia.org/wiki/Great-circle_distance#From_chord_length
        return Math.asin(dist / 2) * 2;
    }

    @Override
    public boolean isEqual(Coordinate c) {
        if (c == this) {
            return true;
        }

        CartesianCoordinate thisAsCartesian = this.asCartesianCoordinate();
        CartesianCoordinate cartesianCoordinate = c.asCartesianCoordinate();
        boolean allCoordEqual = Math.abs(thisAsCartesian.getX() - cartesianCoordinate.getX()) < PRECISION_EPSILON &&
                                Math.abs(thisAsCartesian.getY() - cartesianCoordinate.getY()) < PRECISION_EPSILON &&
                                Math.abs(thisAsCartesian.getZ() - cartesianCoordinate.getZ()) < PRECISION_EPSILON;
        return allCoordEqual;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Coordinate) {
            return isEqual((Coordinate) object);
        }
        return false;
    }
}
