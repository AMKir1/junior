package ru.job4j.array;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class ArrayAddArrayTestTest.
	*/
	public class ArrayAddArrayTest {
	/**
	*
	*/
	@Test
	public void whenArrayOneAddArrayTwo() {
		ArrayAddArray ad = new ArrayAddArray();
		int[] arr1 = {1, 2, 3, 4, 5};
		int[] arr2 = {1, 2, 3, 4, 5, 6};
		int[] result = ad.sumArrays(arr1, arr2);
		int[] expected = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6};
		assertThat(result, is(expected));
	}
}