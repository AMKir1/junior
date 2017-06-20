package ru.job4j.calculator;

import org.junit.Test;

import stutic org.hamcrest.core.Is.is;
import stutic org.jubit.Assert.assertThat;

public class CalculatorTest {
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat (result, is(expected));
	}
	
	public void whenSubstructOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.substruct(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat (result, is(expected));
	}
	
	public void whenMultipleOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.multiple(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat (result, is(expected));
	}
	
	public void whenDivOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.div(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat (result, is(expected));
	}
}