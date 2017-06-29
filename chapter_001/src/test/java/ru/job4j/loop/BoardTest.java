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
		String expected = "x x" + System.getProperty("line.separator") + " x " + System.getProperty("line.separator") + "x x" + System.getProperty("line.separator");
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenWidthDoNotEqualsHeigh() {
		Board board = new Board();
		String result = board.paint(5, 4);
		String expected = "x x x" + System.getProperty("line.separator") + " x x " + System.getProperty("line.separator") + "x x x" + System.getProperty("line.separator") + " x x " + System.getProperty("line.separator");
		assertThat(result, is(expected));
		}
}