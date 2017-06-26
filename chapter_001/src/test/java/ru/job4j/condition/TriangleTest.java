package ru.job4j.condition;

	import org.junit.Test;
	//import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	import static org.hamcrest.number.IsCloseTo.closeTo;

	/**
	* class TriangleTest
	* It's try to find point in the function.
	*/
public class TriangleTest {
	/**
	*
	*/
	@Test
	public void whenTriangleIs() {
		Point pointA = new Point(-1, -2);
		Point pointB = new Point(3, 2);
		Point pointC = new Point(5, -2);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
		double result = triangle.area();
		double expected = 12;
		assertThat(result, closeTo(expected, 0.01));
	}
	/**
	*
	*/
	public void whenNoTriangle() {
		Point pointA = new Point(-1, -1);
		Point pointB = new Point(3, 3);
		Point pointC = new Point(5, 5);
		Triangle triangle = new Triangle(pointA, pointB, pointC);
		double result = triangle.area();
		double expected = 0;
		assertThat(result, closeTo(expected, 0.01));
	}
}