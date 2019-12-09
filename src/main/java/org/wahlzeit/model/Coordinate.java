package org.wahlzeit.model;

public interface Coordinate{
    // Cartesian
    public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException;
    public double getCartesianDistance(Coordinate coordinate) throws IllegalStateException;
    // Spheric
    public SphericCoordinate asSphericCoordinate() throws IllegalStateException;
    public double getCentralAngle(Coordinate coordinate) throws IllegalStateException;

    public boolean isEqual(Coordinate coordinate) throws IllegalStateException;
}
