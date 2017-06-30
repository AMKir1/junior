package ru.job4j.array;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class BubbleSortTest.
	*/
public class BubbleSortTest {
	/**
	*
	*/
	@Test
	public void whenLengthIsEven() {
		BubbleSort bubble = new BubbleSort();
		int[] mass = new int[] {1, 4, 3, 2};
		int[] result = bubble.sort(mass);
		int[] expected = {1, 2, 3, 4};
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	@Test
	public void whenLengthIsNotEven() {
		BubbleSort bubble = new BubbleSort();
		int[] mass = new int[] {7, 1, 4, 3, 2};
		int[] result = bubble.sort(mass);
		int[] expected = {1, 2, 3, 4, 7};
		assertThat(result, is(expected));
		}
}