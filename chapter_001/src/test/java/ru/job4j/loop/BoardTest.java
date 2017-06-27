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
		String result = board.paint(3, 3);
		String expected = "x x\r\n x \r\nx x\r\n";
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenWidthDoNotEqualsHeigh() {
		Board board = new Board();
		String result = board.paint(5, 4);
		String expected = "x x x\r\n x x \r\nx x x\r\n x x \r\n";
		assertThat(result, is(expected));
		}
}