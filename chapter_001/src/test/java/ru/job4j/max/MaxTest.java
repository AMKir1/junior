package ru.job4j.max;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class MaxTest
	* Summation first and second.
	*/
public class MaxTest {
	/**
	*
	*/
	@Test
	public void whenNoMaxNumber() {
		Max maxi = new Max();
		double result = maxi.max(1, 1);
		double expected = 1;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenMaxNumberIsTheFirstNumber() {
		Max maxi = new Max();
		double result = maxi.max(2, 1);
		double expected = 2;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenMaxNumberIsTheSecondNumber() {
		Max maxi = new Max();
		double result = maxi.max(1, 2);
		double expected = 2;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenMaxNumberIsTheThirdNumber() {
		Max maxi = new Max();
		double result = maxi.max(1, 2, 3);
		double expected = 3;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenMaxNumberIsAllOfThem() {
		Max maxi = new Max();
		double result = maxi.max(1, 1, 1);
		double expected = 1;
		assertThat(result, is(expected));
	}
}