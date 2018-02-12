/**
 * This is the Java implementation of class Vector from lecture 2.
 * 
 * 
 *
 */
public class Vector {
	/** x value of vector endpoint */
	private double x= 0;
	
	/** y value of vector endpoint */
	private double y= 0;
	
	/**
	 * Returns the square of a number.
	 *
	 * @param x the number
	 * @return the square of the number
	 */
	private static double sqr(double x) {
		return x * x;
	}

	/**
	 * Constructor for a Vector.
	 *
	 * @param v another vector
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructor for a Vector.
	 *
     * @param v another Vector
	 */
	public Vector(Vector v) {
		this.x = v.x;
		this.y = v.y;
	}

	/**
	 * Get the x endpoint of vector.
	 * 
	 * @return the x endpoint
	 */
	public double x() {
		return x;
	}
	
	/**
	 * Get the y endpoint of vector.
	 * 
	 * @return the y endpoint
	 */
	public double y() {
		return y;
	}
	
	/**
	 * The length of the vector relative to the origin.
	 *
	 * @return the length of the vector;
	 */
	public double length() {
		return Math.sqrt(Vector.sqr(x) + Vector.sqr(y));
	}

	/**
	 * The angle of this vector relative to the origin.
	 *
	 * @return the angle of the vector relative to the origin in radians
	 */
	public double angle() {
		return Math.atan2(x,y);
	}

	/**
	 * Returns a Vector that is offset from this vector.
	 *
	 * @param off the offset
	 * @return a vector that is offset from the input vector
	 */
	public Vector add (double off) {
		return new Vector(x + off, y + off);
	}

	/**
	 * Returns a Vector that is the sum of this and the input vectors.
	 *
	 * @param v the other vector
	 * @return a vector that is the sum of two vectors
	 */
	public Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y);
	}

	/**
	 * Returns the negative of a vector that is the negative of
	 * its x and y values.
	 *
	 * @return the negative of the vector
	 */
	public Vector negative() {
		return new Vector(-x, -y);
	}

	/**
	 * Returns a Vector that is the difference of this and the input vectors.
	 * This is defined as: A-B = A + (-B)
	 *
	 * @param v the other vector
	 * @return the vector difference
	 */
	public Vector subtract(Vector v) {
		return add(v.negative());
	}

	/**
	 * Tests operations on Vector
	 * 
	 * @param args input arguments
	 */
	public static void main(String[] args) {
		Vector v1 = new Vector(2, 4);
		System.out.printf("v1: %f, %f\n", v1.x, v1.y);

		Vector v2 = new Vector(v1);
		System.out.printf("-v1: %f, %f\n", v2.x, v2.y);

		Vector v3 = v1.add(v2);
		System.out.printf("v1 + (-v1): %f, %f\n", v3.x, v3.y);

		Vector v4 = v1.subtract(v2);
		System.out.printf("v1 - (-v1): %f, %f\n", v4.x, v4.y);

		Vector v5 = v1.add(5);
		System.out.printf("5 + v1: %f, %f\n", v5.x, v5.y);
	}

}
