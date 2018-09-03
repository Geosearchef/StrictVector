package de.geosearchef.strictvector;

public strictfp interface StrictVector
{
	public double length();
	public double lengthSquared();
	public StrictVector negate();
	public StrictVector normalise();
	public StrictVector scale(double scale);
}
