package ru.job4j.calculator;

/**
 * Class Calculate решение задачи части 001 урок1.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
	/**
	*
	*/
	private double result;
	/**
	*
	*@param
	*
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	*
	*@param
	*
	*/
	public void substruct(double first, double second) {
		this.result = first - second;
	}
	/**
	*
	*@param
	*
	*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	/**
	*
	*@param
	*
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}
	/**
	*
	*@return
	*
	*/
	public double getResult() {
		return this.result;
	}
}
