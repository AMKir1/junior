package ru.job4j.array;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class TurnTest
	* Factorial from N.
	*/
public class TurnTest {
	/**
	*
	*/
	@Test
	public void whenLengthIsEven() {
		Turn turn = new Turn();
		int[] mass = new int[] {1, 4, 3, 2};
		int[] result = turn.back(mass);
		int[] expected = {2, 3, 4, 1};
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	@Test
	public void whenLengthIsNotEven() {
		Turn turn = new Turn();
		int[] mass = new int[] {1, 2, 3};
		int[] result = turn.back(mass);
		int[] expected = {3, 2, 1};
		assertThat(result, is(expected));
		}
}