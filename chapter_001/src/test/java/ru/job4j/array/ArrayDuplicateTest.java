package ru.job4j.array;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class ArrayDuplicateTest.
	*/
	public class ArrayDuplicateTest {
	/**
	*
	*/
	@Test
	public void whenDuplicatesThenArrayWithoutDuplicate() {
		ArrayDuplicate ad = new ArrayDuplicate();
		String[] words = {"Hello", "World", "Hello", "Super", "World", "Super", "Puper"};
		String[] result = ad.remove(words);
		String[] expected = {"Hello", "World", "Super", "Puper"};
		assertThat(result, is(expected));
	}
}