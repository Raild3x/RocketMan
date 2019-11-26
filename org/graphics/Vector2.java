package org.graphics;

public class Vector2 {

	public float x,y;
	
	public Vector2() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	public Vector2(int x, int y) {
		this.x = (float) x;
		this.y = (float) y;
	}
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2(double x, double y) {
		this.x = (float) x;
		this.y = (float) y;
	}
	
	public boolean equals(Vector2 other) {
		return (this.x == other.x && this.y == other.y);
	}
	
	public double distance(Vector2 other) {
		float v0 = other.x - this.x;
		float v1 = other.y - this.y;
		return Math.sqrt(v0*v0 + v1*v1);
	}
	
	public static double distance(Vector2 a, Vector2 b) {
		float v0 = b.x - a.x;
		float v1 = b.y - a.y;
		return Math.sqrt(v0*v0 + v1*v1);
	}
	
	//Returns the length of the vector using Pythagorean Theorem
	public double length() {
		return Math.sqrt(x*x+y*y);
	}
	
	// Turns the vector into its Unit Vector (length of 1)
	public void normalize() {
		double length = Math.sqrt(x*x+y*y);
		if (length != 0.0) {
			float s = 1.0f / (float)length;
			x = x*s;
			y = y*s;
		}
	}
	
	// BASIC MATH METHODS
	// ADDITION
	public void add(Vector2 other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public static Vector2 add(Vector2 a, Vector2 b) {
		return new Vector2(a.x+b.x,a.y+b.y);
	}
	
	//SUBTRACTION
	public void sub(Vector2 other) {
		this.x -= other.x;
		this.y -= other.y;
	}
	public static Vector2 sub(Vector2 a, Vector2 b) {
		return new Vector2(a.x-b.x,a.y-b.y);
	}
	
	//MULTIPLICATION
	public void mult(double v) {
		x = (float) (x*v);
		y = (float) (y*v);
	}
	public void mult(float v) {
		x = x*v;
		y = y*v;
	}
	public void mult(int v) {
		x = x*v;
		y = y*v;
	}
	
	public static Vector2 mult(Vector2 a, float v) {
		return new Vector2(a.x*v,a.y*v);
	}
	public static Vector2 mult(Vector2 a, int v) {
		return new Vector2(a.x*v,a.y*v);
	}
	public static Vector2 mult(float v, Vector2 a) {
		return new Vector2(a.x*v,a.y*v);
	}
	public static Vector2 mult(int v, Vector2 a) {
		return new Vector2(a.x*v,a.y*v);
	}
	
	//DIVISION
	public void div(float v) {
		x = x/v;
		y = y/v;
	}
	public void div(int v) {
		x = x/v;
		y = y/v;
	}
	
	public static Vector2 div(Vector2 a, float v) {
		return new Vector2(a.x/v,a.y/v);
	}
	public static Vector2 div(Vector2 a, int v) {
		return new Vector2(a.x/v,a.y/v);
	}
	public static Vector2 div(float v, Vector2 a) {
		return new Vector2(a.x/v,a.y/v);
	}
	public static Vector2 div(int v, Vector2 a) {
		return new Vector2(a.x/v,a.y/v);
	}
	
	//COMPLEX VECTOR METHODS
	public float dot(Vector2 other) {
		return x*other.x+y*other.y;
	}
	
	// Projects a Vector2 onto another given Vector2 and returns a new one
	public Vector2 proj(Vector2 other) {
		return mult((float) (this.dot(other)/this.length()), this);
	}

	// Returns the angle between two vectors
	public double angleBetween(Vector2 other) {
		return Math.acos(this.dot(other)/(this.length()*other.length()));
	}
	
	// Return true if given Vectors are perpendicular
	public boolean isOrthogonal(Vector2 other) {
		return false;
	}
	
	// linear interpolation of single numbers
	private static float lerp(float x, float y, float alpha) {
		return x*(1-alpha) + y*alpha;
	}
	
	// Linear interpolation of Vector2s
	public Vector2 lerp(Vector2 other, float alpha) {
		float retX = lerp(this.x,other.x,alpha);
		float retY = lerp(this.y,other.y,alpha);
		return new Vector2(retX, retY);
	}
	
}
