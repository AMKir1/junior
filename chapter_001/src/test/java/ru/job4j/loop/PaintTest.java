package ru.job4j.loop;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class PaintTest
	* Factorial from N.
	*/
public class PaintTest {
	/**
	*
	*/
	@Test
	public void whenH() {
		Paint pairam = new Paint();
		String result = pairam.pairamid(3);
		String expected = "   ^" + System.getProperty("line.separator") + "  ^^^" + System.getProperty("line.separator") + " ^^^^^" + System.getProperty("line.separator");
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenHNotEven() {
		Paint pairam = new Paint();
		String result = pairam.pairamid(4);
		String expected = "    ^" + System.getProperty("line.separator") + "   ^^^" + System.getProperty("line.separator") + "  ^^^^^" + System.getProperty("line.separator") + " ^^^^^^^" + System.getProperty("line.separator");
		assertThat(result, is(expected));
		}
}