package ru.job4j.array;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class RotateArrayTest.
	*/
public class RotateArrayTest {
	/**
	*
	*/
	@Test
	public void whenLengthIsEven() {
		RotateArray ra = new RotateArray();
		int[][] arr = {{1, 2}, {3, 4}};
		int[][] result = ra.rotate(arr);
	int[][] expected = {{3, 1}, {4, 2}};
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	@Test
	public void whenLengthIsNotEven() {
		RotateArray ra = new RotateArray();
		int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] result = ra.rotate(arr);
		int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(result, is(expected));
		}
}