package org.wahlzeit.model;

//import java.util.Objects;

public class CartesianCoordinate implements Coordinate{
    private double x;
    private double y;
    private double z;
    private static final double PRECISION_EPSILON = 1e-5;

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    public double getDistance(Coordinate c){
        CartesianCoordinate cartesiancoord = c.asCartesianCoordinate();


        double sum = Math.pow(this.x - cartesiancoord.x, 2)
                    + Math.pow(this.y - cartesiancoord.y, 2)
                    + Math.pow(this.z - cartesiancoord.z, 2);
        return Math.sqrt(sum);
    }

    @Override
    public double getCartesianDistance(Coordinate c) {
        CartesianCoordinate cartesiancoord = c.asCartesianCoordinate();
        return this.getDistance(cartesiancoord);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        double phi = Math.atan(this.y / this.x);
        double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        double theta = Math.acos(this.z / radius);
        SphericCoordinate sphericcoord = new SphericCoordinate(phi, theta, radius);
        return sphericcoord;
    }

    @Override
    public double getCentralAngle(Coordinate c) {
        double dist = this.getCartesianDistance(c);
        return Math.asin(dist / 2) * 2;
    }

    @Override
    public boolean isEqual(Coordinate c){
        if (c == this){
            return true;
        }
        CartesianCoordinate cartesianCoordinate = c.asCartesianCoordinate();
        boolean allCoordEqual = Math.abs(this.x - cartesianCoordinate.x) < PRECISION_EPSILON &&
                                Math.abs(this.y - cartesianCoordinate.y) < PRECISION_EPSILON &&
                                Math.abs(this.z - cartesianCoordinate.z) < PRECISION_EPSILON;
        return allCoordEqual;
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
		tmp = Double.doubleToLongBits(x);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(y);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(z);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		return result;
	}
}