package ru.job4j.calculator;

/**
 * Class Calculator решение задачи части 001 урок1.
 *
 * @author Kirillovykh Andrei (mailto:andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
	/**
	*
	*/
	private double result;
	/**
	* Summation first and second.
	* @param first - first args.
	* @param second - second args.
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	* Summation first and second.
	* @param first - first args.
	* @param second - second args.
	*/
	public void substruct(double first, double second) {
		this.result = first - second;
	}
	/**
	* Summation first and second.
	* @param first - first args.
	* @param second - second args.
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	/**
	* Summation first and second.
	* @param first - first args.
	* @param second - second args.
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}
/**
	* Summation first and second.
	* @return result of calculation.
	*/
	public double getResult() {
		return this.result;
	}
}
