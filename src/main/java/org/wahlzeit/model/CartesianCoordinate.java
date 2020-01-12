package org.wahlzeit.model;

import java.util.HashMap;
import org.wahlzeit.annotations.PatternInstance;

// https://en.wikipedia.org/wiki/Template_method_pattern
@PatternInstance(
    patternName = "Template Method",
    participants = {
        "SubClass"
    }
)
// https://en.wikipedia.org/wiki/Flyweight_pattern
@PatternInstance(
    patternName = "Flyweight",
    participants = {
        "Flyweight"
    }
)

public class CartesianCoordinate extends AbstractCoordinate {
    private final double x;
    private final double y;
    private final double z;

    private static HashMap<Integer, CartesianCoordinate> objects = new HashMap<Integer, CartesianCoordinate>();

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

    public static CartesianCoordinate createOrGetByComponents(double x_, double y_, double z_) {
        int hash = doHashCode(x_, y_, z_);
        CartesianCoordinate obj = objects.get(hash);
        if (obj == null) {
            CartesianCoordinate coord = new CartesianCoordinate(x_, y_, z_);
            objects.put(hash, coord);
            return coord;
        } else {
            return obj;
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

    public static int doHashCode(double x_, double y_, double z_) {
        final int prime = 31;
        int result = 1;
        long tmp;
        tmp = Double.doubleToLongBits(x_);
        result = prime * result + (int) (tmp ^ (tmp >>> 32));
        tmp = Double.doubleToLongBits(y_);
        result = prime * result + (int) (tmp ^ (tmp >>> 32));
        tmp = Double.doubleToLongBits(z_);
        result = prime * result + (int) (tmp ^ (tmp >>> 32));
        return result;
    }

    @Override
    public int hashCode() {
        return doHashCode(this.x, this.y, this.z);
    }
}
