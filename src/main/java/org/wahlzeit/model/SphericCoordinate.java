package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
    private double phi;
    private double theta;
    private double radius;

    protected void assertClassInvariants() {
        // component validity checks
        // isFinite returns false if NaN or infinite
        assert Double.isFinite(this.phi);
        assert Double.isFinite(this.theta);
        assert Double.isFinite(this.radius);

        // spheric specifics
        assert this.radius >= 0;
        assert this.theta >= 0;
        assert this.phi >= 0;
        assert this.theta <= 180;
        assert this.phi < 360;
    }

    public SphericCoordinate(double phi, double theta, double radius){
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

    public void setPhi(double phi) {
        this.phi = phi;
        assertClassInvariants();
    }

    public void setTheta(double theta) {
        this.theta = theta;
        assertClassInvariants();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        assertClassInvariants();
    }

    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    @Override
    public CartesianCoordinate asCartesianCoordinate() {
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