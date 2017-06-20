package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.jubit.Assert.assertThat;
 /**
 * Class CalculateTest
 *
 * Let's call this as the first sentence,
 * so here, we must place a period.
 *
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CalculatorTest {
	/**
	*
	*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenSubstructOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.substruct(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenMultipleOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.multiple(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenDivOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.div(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
}