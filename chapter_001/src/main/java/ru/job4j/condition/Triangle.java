package ru.job4j.condition;

/**
 * Class Triangle решение задачи части 001 урок 3.3.
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
	/**
	* @args a - first args.
	*/
	private Point a;
	/**
	* @args b - second args.
	*/
	private Point b;
	/**
	* @args c - third args.
	*/
	private Point c;
	/**
	* Main points.
	* @param a - first args.
	* @param b - second args.
	* @param c - third args.
	*/
    public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
    }
	/**
	* Coefficient befor points.
	* @return answer about triangle.
	*/
	public double area() {
		double ab = Math.sqrt(((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY())));
		double bc = Math.sqrt(((b.getX() - c.getX()) * (b.getX() - c.getX()) + (b.getY() - c.getY()) * (b.getY() - c.getY())));
		double ca = Math.sqrt(((c.getX() - a.getX()) * (c.getX() - a.getX()) + (c.getY() - a.getY()) * (c.getY() - a.getY())));
		if (ab + bc <= ca || ab + ca <= bc || bc + ca <= ab) {
			return 0;
		} else {
			double p = (ab + bc + ca) / 2;
			double s = Math.sqrt(p * (p - ab) * (p - bc) * (p - ca));
			return s;
		}
	}
}
