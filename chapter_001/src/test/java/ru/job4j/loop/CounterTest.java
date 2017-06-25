package ru.job4j.loop;

	import org.junit.Test;
	import static org.hamcrest.core.Is.is;
	import static org.junit.Assert.assertThat;
	/**
	* class CounterTest
	* Summation first and second.
	*/
public class CounterTest {
	/**
	*
	*/
	@Test
	public void whenNoEvenElems() {
		Counter count = new Counter();
		double result = count.add(1, 1);
		double expected = 0;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenEvenElems() {
		Counter count = new Counter();
		double result = count.add(1, 5);
		double expected = 6;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenEvenElemsInTheEnd() {
		Counter count = new Counter();
		double result = count.add(1, 4);
		double expected = 6;
		assertThat(result, is(expected));
	}
	/**
	*
	*/
	public void whenElemsInStart() {
		Counter count = new Counter();
		double result = count.add(4, -3);
		double expected = 0;
		assertThat(result, is(expected));
	}
}