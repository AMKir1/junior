package ru.job4j.condition;

/**
 * Class Point решение задачи части 001 урок 3.2.
 * y(x)= a*x + b
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Point {
	/**
	* @param x - first args.
	*/
	private int x;
	/**
	* @param y - second args.
	*/
	private int y;
	/**
	* Main points.
	* @param x - first args.
	* @param y - second args.
	*/
    public Point(int x, int y) {
		this.x = x;
		this.y = y;
    }
	/**
	* @return cordinate of x.
	*/
	public int getX() {
		return this.x;
	}
	/**
	* @return cordinate of y.
	*/
	public int getY() {
		return this.y;
	}
	/**
	* Coefficient befor points.
	* @param a - first args.
	* @param b - second args.
	* @return answer about point.
	*/
	public boolean is(int a, int b) {
		return this.y == this.x * a + b;
	}
}
