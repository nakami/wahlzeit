package org.wahlzeit.model;

public class Coordinate{
    private double x;
    private double y;
    private double z;

    public Coordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
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
        boolean allCoordEqual = this.x == c.x &&
                                this.y == c.y &&
                                this.z == c.z;
        return allCoordEqual;
    }

    @Override
    public boolean equals(Object object){
        if (object instanceof Coordinate){
            return isEqual((Coordinate) object);
        }
        return false;
    }
}