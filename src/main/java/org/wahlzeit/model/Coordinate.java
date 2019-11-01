package org.wahlzeit.model;

public class Coordinate{
    private double x;
    private double y;
    private double z;
    private static final double PRECISION_EPSILON = 1e-5;

    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setZ(double z){
        this.z = z;
    }

    public double getDistance(Coordinate c){
        double sum = Math.pow(this.x - c.x, 2)
                    + Math.pow(this.y - c.y, 2)
                    + Math.pow(this.z - c.z, 2);
        return Math.sqrt(sum);
    }

    public boolean isEqual(Coordinate c){
        if (c == this){
            return true;
        }
        boolean allCoordEqual = Math.abs(this.x - c.x) < PRECISION_EPSILON &&
                                Math.abs(this.y - c.y) < PRECISION_EPSILON &&
                                Math.abs(this.z - c.z) < PRECISION_EPSILON;
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