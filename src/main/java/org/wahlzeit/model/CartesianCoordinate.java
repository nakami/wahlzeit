package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
    private double x;
    private double y;
    private double z;

    protected void assertClassInvariants() {
        // component validity checks
        // isFinite returns false if NaN or infinite
        assert Double.isFinite(this.x);
        assert Double.isFinite(this.y);
        assert Double.isFinite(this.z);
    }

    public CartesianCoordinate(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
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
        assert Double.isFinite(x);
        this.x = x;
    }

    public void setY(double y) {
        assert Double.isFinite(y);
        this.y = y;
    }

    public void setZ(double z) {
        assert Double.isFinite(z);
        this.z = z;
    }
    
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        assertClassInvariants();
        double phi = Math.atan(this.y / this.x);
        double radius = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        double theta = Math.acos(this.z / radius);
        SphericCoordinate sphericcoord = new SphericCoordinate(phi, theta, radius);
        return sphericcoord;
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
