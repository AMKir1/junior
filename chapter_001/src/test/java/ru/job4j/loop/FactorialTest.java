package ru.job4j.loop;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class FactorialTest
	* Factorial from N.
	*/
public class FactorialTest {
	/**
	*
	*/
	@Test
	public void whenNMoreThanZero() {
		Factorial factorial = new Factorial();
		double result = factorial.calc(5);
		double expected = 120;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenNIsEqualToZero() {
		Factorial factorial = new Factorial();
		double result = factorial.calc(0);
		double expected = 1;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenNLessThanZero() {
		Factorial factorial = new Factorial();
		double result = factorial.calc(-1);
		double expected = 0;
		assertThat(result, is(expected));
	}
}