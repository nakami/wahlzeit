package org.wahlzeit.model;

public interface Coordinate{
    // Cartesian
    public CartesianCoordinate asCartesianCoordinate();
    public double getCartesianDistance(Coordinate coordinate);
    // Spheric
    public SphericCoordinate asSphericCoordinate();
    public double getCentralAngle(Coordinate coordinate);

    public boolean isEqual(Coordinate coordinate);
}
