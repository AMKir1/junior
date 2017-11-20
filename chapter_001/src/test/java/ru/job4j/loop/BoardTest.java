package ru.job4j.loop;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class BoardTest
	* Factorial from N.
	*/
public class BoardTest {
	/**
	*
	*/
	@Test
	public void whenWidthEqualsHeigh() {
		Board board = new Board();
		StringBuilder build = new StringBuilder();
		String result = board.paint(3, 3);
		String expected = String.format("x x%s x %<sx x%<s", build.append(System.getProperty("line.separator")));
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenWidthDoNotEqualsHeigh() {
		Board board = new Board();
		StringBuilder build = new StringBuilder();
		String result = board.paint(5, 4);
		String expected = String.format("x x x%s x x %<sx x x%<s x x %<s", build.append(System.getProperty("line.separator")));
		assertThat(result, is(expected));
		}
}