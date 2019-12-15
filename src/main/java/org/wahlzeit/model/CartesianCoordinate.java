package org.wahlzeit.model;
import java.util.HashMap;

public class CartesianCoordinate extends AbstractCoordinate {
    private final double x;
    private final double y;
    private final double z;

    private static HashMap<CartesianCoordinate, CartesianCoordinate> objects = new HashMap<CartesianCoordinate, CartesianCoordinate>();

    protected void assertClassInvariants() throws IllegalStateException {
        // component validity checks
        // isFinite returns false if NaN or infinite
        String error_msg = "";
		if(!Double.isFinite(this.x) || !Double.isFinite(this.y) || !Double.isFinite(this.z)) {
            error_msg = String.format("At least one Coordinate component not finite: x=%f, y=%f, z=%f", this.x, this.y, this.z);
            throw new IllegalStateException(error_msg);
        }
    }

    // private constructor called within createOrGetByComponents(...)
    private CartesianCoordinate(double x, double y, double z) throws IllegalStateException {
        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    public static CartesianCoordinate createOrGetByComponents(double phi, double theta, double radius) {
        CartesianCoordinate coord = new CartesianCoordinate(phi, theta, radius);
        if (objects.putIfAbsent(coord, coord) == null) {
            return coord;
        } else {
            return objects.get(coord);
        }
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

    public CartesianCoordinate setXAndReturn(double x) throws IllegalArgumentException {
        if (!Double.isFinite(x))
            throw new IllegalArgumentException("Provided argument x is not finite!");
        return createOrGetByComponents(x, this.y, this.z);
    }

    public CartesianCoordinate setYAndReturn(double y) throws IllegalArgumentException {
        if (!Double.isFinite(y))
            throw new IllegalArgumentException("Provided argument y is not finite!");
        return createOrGetByComponents(this.x, y, this.z);
    }

    public CartesianCoordinate setZAndReturn(double z) throws IllegalArgumentException {
        if (!Double.isFinite(z))
            throw new IllegalArgumentException("Provided argument z is not finite!");
        return createOrGetByComponents(this.x, this.y, z);
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
        SphericCoordinate sphericcoord = SphericCoordinate.createOrGetByComponents(phi, theta, radius);
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
