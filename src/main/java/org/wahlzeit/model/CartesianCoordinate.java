package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
    private double x;
    private double y;
    private double z;

    protected void assertClassInvariants() throws IllegalStateException {
        // component validity checks
        // isFinite returns false if NaN or infinite
        String error_msg = "";
		if(!Double.isFinite(this.x) || !Double.isFinite(this.y) || !Double.isFinite(this.z)) {
            error_msg = String.format("At least one Coordinate component not finite: x=%f, y=%f, z=%f", this.x, this.y, this.z);
            throw new IllegalStateException(error_msg);
        }
    }

    public CartesianCoordinate(double x, double y, double z) throws IllegalStateException {
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

    public void setX(double x) throws IllegalArgumentException {
        if (!Double.isFinite(x))
            throw new IllegalArgumentException("Provided argument x is not finite!");
        this.x = x;
    }

    public void setY(double y) throws IllegalArgumentException {
        if (!Double.isFinite(y))
            throw new IllegalArgumentException("Provided argument y is not finite!");
        this.y = y;
    }

    public void setZ(double z) throws IllegalArgumentException {
        if (!Double.isFinite(z))
            throw new IllegalArgumentException("Provided argument z is not finite!");
        this.z = z;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    @Override
    public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
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
