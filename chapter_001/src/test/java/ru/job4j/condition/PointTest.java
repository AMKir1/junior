package ru.job4j.condition;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class PointTest
	* It's try to find point in the function.
	*/
public class PointTest {
	/**
	*
	*/
	@Test
	public void whenPointIs() {
		Point point1 = new Point(1, 1);
		boolean result = point1.is(1, 0);
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenNoPoints() {
		Point point1 = new Point(1, 1);
		boolean result = point1.is(0, 0);
		boolean expected = true;
		assertThat(result, is(expected));
	}
}