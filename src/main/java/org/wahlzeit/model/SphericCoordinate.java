package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
    private double phi;
    private double theta;
    private double radius;

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

    public SphericCoordinate(double phi, double theta, double radius) throws IllegalStateException {
        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariants();
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

    public void setPhi(double phi) throws IllegalArgumentException {
        if (!Double.isFinite(phi))
            throw new IllegalArgumentException("Provided argument phi is not finite!");
        this.phi = phi;
    }

    public void setTheta(double theta) throws IllegalArgumentException {
        if (!Double.isFinite(theta))
            throw new IllegalArgumentException("Provided argument theta is not finite!");
        this.theta = theta;
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (!Double.isFinite(radius))
            throw new IllegalArgumentException("Provided argument radius is not finite!");
        this.radius = radius;
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
        return new CartesianCoordinate(x, y, z);
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