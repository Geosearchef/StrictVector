package de.geosearchef.strictvector;

import org.lwjgl.util.vector.Vector3f;

public strictfp class StrictVector3f implements StrictVector
{
	public double x;
	public double y;
	public double z;
	
	public StrictVector3f()
	{
		x = 0d;
		y = 0d;
		z = 0d;
	}
	
	public StrictVector3f(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public StrictVector3f(StrictVector3f src)
	{
		this.x = src.x;
		this.y = src.y;
		this.z = src.z;
	}
	
	public StrictVector3f(Vector3f src)
	{
		this.x = src.x;
		this.y = src.y;
		this.z = src.z;
	}
	
	public StrictVector3f add(StrictVector3f r)
	{
		return new StrictVector3f(this.x + r.x, this.y + r.y, this.z + r.z);
	}
	
	public StrictVector3f sub(StrictVector3f r)
	{
		return new StrictVector3f(this.x - r.x, this.y - r.y, this.z - r.z);
	}
	
	public double dot(StrictVector3f r)
	{
		return this.x * r.x + this.y * r.y + this.z * r.z;
	}
	
	public StrictVector3f cross(StrictVector3f r)
	{
		StrictVector3f res = new StrictVector3f();
		
		res.x = this.y * r.z - this.z * r.y;
		res.y = this.z * r.x - this.x * r.z;
		res.z = this.x * r.y - this.y * r.x;
		
		return res;
	}
	
	public double angle(StrictVector3f r)
	{
		StrictVector3f v1 = new StrictVector3f(this).normalise();
		StrictVector3f v2 = new StrictVector3f(r).normalise();
		
//		double dotProduct = v1.dot(v2);
//		StrictVector3f cross = v1.cross(v2);
//		
//		return StrictMath.acos(dotProduct) * ();
		
		double s = v1.cross(v2).length();
		double c = v1.dot(v2);
		return Math.atan2(s, c);
	}
	
	public Vector3f getVector3f()
	{
		return new Vector3f((float)this.x, (float)this.y, (float)this.z);
	}

	@Override
	public double length()
	{
		return StrictMath.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	@Override
	public double lengthSquared()
	{
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	@Override
	public StrictVector3f negate()
	{
		this.x = - this.x;
		this.y = - this.y;
		this.z = - this.z;
		return this;
	}

	@Override
	public StrictVector3f normalise()
	{
		double length = this.length();
		this.x /= length;
		this.y /= length;
		this.z /= length;
		return this;
	}

	@Override
	public StrictVector3f scale(double scale)
	{
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		return this;
	}
	
	@Override
	public String toString()
	{
		return "StrictVector3f: [" + x + "|" + y + "|" + z + "]";
	}
	
	@Override
	public StrictVector3f clone()
	{
		return new StrictVector3f(this);
	}
	
	
	public StrictVector2f xz()
	{
		return new StrictVector2f(this.x, this.z);
	}
}
