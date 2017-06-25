package ru.job4j.calculator;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class CalculatorTest
	* Summation first and second.
	*/
public class CalculatorTest {
	/**
	* Summation first and second.
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
	* Summation first and second.
	*/
    public void whenAddOneSubOneThenTwo() {
        Calculator calc = new Calculator();
        calc.substruct(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
	/**
	* Summation first and second.
	*/
    public void whenAddOneMultOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
	/**
	* Summation first and second.
	*/
	public void whenAddOneDivOneThenTwo() {
        Calculator calc = new Calculator();
        calc.div(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}