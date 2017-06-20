package ru.job4j.calculator;

/**
 * Class Calculate решение задачи части 001 урок1.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculate {
 
	private double result;
	
	public void add(double first, double second){
		this.result = first + second;
	}
	
	public void substruct(double first, double second){
		this.result = first - second;
	}
	
	public void multiple(double first, double second){
		this.result = first * second;
	}
	
	public void div(double first, double second){
		this.result = first / second;
	}
	
	public double getResult(){
		return this.result;
	}
}
