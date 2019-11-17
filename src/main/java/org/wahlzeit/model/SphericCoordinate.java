package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate implements Coordinate {
    private double phi;
    private double theta;
    private double radius;

    public SphericCoordinate(double phi, double theta, double radius){
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;
    }

    public double getPhi() {
        return this.phi;
    }

    public double getTheta() {
        return this.theta;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setPhi(double phi) {
        this.phi = phi;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);
        return new CartesianCoordinate(x, y, z);
    }

    @Override
    public double getCartesianDistance(Coordinate c) {
        return this.asCartesianCoordinate().getCartesianDistance(c);
    }

    public double getDistance(Coordinate c){
        return this.getCartesianDistance(c);
    }

    // calculate central angle in CartesianCoordinate
    @Override
    public double getCentralAngle(Coordinate c) {
        return this.asCartesianCoordinate().getCentralAngle(c);
    }

    // check whether equal in CartesianCoordinate
    @Override
    public boolean isEqual(Coordinate c) {
        return this.asCartesianCoordinate().isEqual(c);
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Coordinate){
            return isEqual((Coordinate) object);
        }
        return false;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long tmp;
		tmp = Double.doubleToLongBits(this.phi);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(this.theta);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(this.radius);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		return result;
	}
}