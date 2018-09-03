package de.geosearchef.strictvector;

import org.lwjgl.util.vector.Vector2f;

public strictfp class StrictVector2f implements StrictVector
{
	public double x;
	public double y;
	
	public StrictVector2f()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public StrictVector2f(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public StrictVector2f(StrictVector2f src)
	{
		this.x = src.x;
		this.y = src.y;
	}
	
	public StrictVector2f(Vector2f src)
	{
		this.x = src.x;
		this.y = src.y;
	}
	
	public StrictVector2f add(StrictVector2f r)
	{
		return new StrictVector2f(this.x + r.x, this.y + r.y);
	}
	
	public StrictVector2f sub(StrictVector2f r)
	{
		return new StrictVector2f(this.x - r.x, this.y - r.y);
	}
	
	public double dot(StrictVector2f r)
	{
		return this.x * r.x + this.y * r.y;
	}
	
	public double angle(StrictVector2f r)
	{
		return StrictMath.atan2(r.y, r.x) - StrictMath.atan2(this.y, this.x);
	}
	
	public double smallestAngle(StrictVector2f r)
	{
		return StrictMath.acos(dot(new StrictVector2f(r).normalise()) / this.length());
	}
	
	public Vector2f getVector2f()
	{
		return new Vector2f((float)this.x, (float)this.y);
	}

	@Override
	public double length()
	{
		return StrictMath.sqrt(this.x * this.x + this.y * this.y);
	}

	@Override
	public double lengthSquared()
	{
		return this.x * this.x + this.y * this.y;
	}

	@Override
	public StrictVector2f negate()
	{
		this.x = - this.x;
		this.y = - this.y;
		return this;
	}

	@Override
	public StrictVector2f normalise()
	{
		double length = this.length();
		this.x /= length;
		this.y /= length;
		return this;
	}

	@Override
	public StrictVector2f scale(double scale)
	{
		this.x *= scale;
		this.y *= scale;
		return this;
	}
	
	@Override
	public String toString()
	{
		return "StrictVector2f: [" + x + "|" + y + "]";
	}
	
	@Override
	public StrictVector2f clone()
	{
		return new StrictVector2f(this);
	}
	
	
	public StrictVector3f xNy(int N)
	{
		return new StrictVector3f(this.x, N, this.y);
	}

	@Override
	public boolean equals(Object other) {
		return other != null && other instanceof StrictVector2f && ((StrictVector2f) other).x == this.x && ((StrictVector2f) other).y == this.y;
	}

	@Override
	public int hashCode() {
		return (int)this.x + (int)this.y * 10;
	}
}
