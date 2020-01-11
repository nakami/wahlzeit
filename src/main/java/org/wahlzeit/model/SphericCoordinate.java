package org.wahlzeit.model;
import java.util.HashMap;

public class SphericCoordinate extends AbstractCoordinate {
    private final double phi;
    private final double theta;
    private final double radius;

    private static HashMap<Integer, SphericCoordinate> objects = new HashMap<Integer, SphericCoordinate>();

    protected void assertClassInvariants() throws IllegalStateException {
        // component validity checks
        // isFinite returns false if NaN or infinite
        String error_msg = "";
		if(!Double.isFinite(this.phi) || ! Double.isFinite(this.theta) || !Double.isFinite(this.radius)) {
            error_msg = String.format("At least one Coordinate component not finite: phi=%f, theta=%f, radius=%f", this.phi, this.theta, this.radius);
            throw new IllegalStateException(error_msg);
        }

        // spheric specifics
		if((this.radius < 0)) {
            error_msg = String.format("radius needs to be zero (inclusive) or greater: radius=%f", this.radius);
            throw new IllegalStateException(error_msg);
        }
		if((this.phi < 0) || this.phi >= 360) {
            error_msg = String.format("phi needs to be between zero (inclusive) and 360 (exclusive): phi=%f", this.phi);
            throw new IllegalStateException(error_msg);
        }
        if((this.theta < 0) || this.theta > 180) {
            error_msg = String.format("theta needs to be between zero (inclusive) and 180 (inclusive): theta=%f", this.theta);
            throw new IllegalStateException(error_msg);
        }
    }

    // private constructor called within createOrGetByComponents(...)
    private SphericCoordinate(double phi, double theta, double radius) throws IllegalStateException {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariants();
    }

    public static SphericCoordinate createOrGetByComponents(double phi_, double theta_, double radius_) {
        int hash = doHashCode(phi_, theta_, radius_);
        SphericCoordinate obj = objects.get(hash);
        if (obj == null) {
            SphericCoordinate coord = new SphericCoordinate(phi_, theta_, radius_);
            objects.put(hash, coord);
            return coord;
        } else {
            return obj;
        }
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

    public SphericCoordinate setPhiAndReturn(double phi) throws IllegalArgumentException {
        if (!Double.isFinite(phi))
            throw new IllegalArgumentException("Provided argument phi is not finite!");
        return createOrGetByComponents(phi, this.theta, this.radius);
    }

    public SphericCoordinate setThetaAndReturn(double theta) throws IllegalArgumentException {
        if (!Double.isFinite(theta))
            throw new IllegalArgumentException("Provided argument theta is not finite!");
        return createOrGetByComponents(this.phi, theta, this.radius);
    }

    public SphericCoordinate setRadiusAndReturn(double radius) throws IllegalArgumentException {
        if (!Double.isFinite(radius))
            throw new IllegalArgumentException("Provided argument radius is not finite!");
        return createOrGetByComponents(this.phi, this.theta, radius);
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
        assertClassInvariants();
        double x = this.radius * Math.sin(this.theta) * Math.cos(this.phi);
        double y = this.radius * Math.sin(this.theta) * Math.sin(this.phi);
        double z = this.radius * Math.cos(this.theta);
        return CartesianCoordinate.createOrGetByComponents(x, y, z);
    }

	public static int doHashCode(double phi_, double theta_, double radius_) {
		final int prime = 31;
		int result = 1;
		long tmp;
		tmp = Double.doubleToLongBits(phi_);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(theta_);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		tmp = Double.doubleToLongBits(radius_);
		result = prime * result + (int) (tmp ^ (tmp >>> 32));
		return result;
	}

    @Override
	public int hashCode() {
		return doHashCode(this.phi, this.theta, this.radius);
	}
}