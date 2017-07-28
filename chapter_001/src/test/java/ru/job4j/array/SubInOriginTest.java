package ru.job4j.array;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class SubInOriginTest.
	*/
public class SubInOriginTest {
	/**
	*
	*/
	@Test
	public void whenSubInOriginSentence() {
		SubInOrigin sb = new SubInOrigin();
		String sub = "иве";
		String origin = "Привет";
		boolean result = sb.contains(origin, sub);
		boolean expected = true;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	@Test
	public void whenSubInNotOriginSentence1() {
		SubInOrigin sb = new SubInOrigin();
		String sub = "Пве";
		String origin = "Привет";
		boolean result = sb.contains(origin, sub);
		boolean expected = false;
		assertThat(result, is(expected));
		}
	/**
	*
	*/
	@Test
	public void whenSubInNotOriginSentence2() {
		SubInOrigin sb = new SubInOrigin();
		String sub = "Приветт";
		String origin = "Привет";
		boolean result = sb.contains(origin, sub);
		boolean expected = false;
		assertThat(result, is(expected));
		}
}