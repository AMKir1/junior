package ru.job4j.diapason;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951]
 * Task: Подсчет функции в диапазоне. [#24251]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionsTest {
    /*
     * Проверка линейной функции.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Functions function = new Functions();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    /*
     * Проверка квадратичной функции
     */
    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Functions function = new Functions();
        List<Double> result = function.diapason(1, 4, x -> 3 * x * x + 2 * x + 1);
        List<Double> expected = Arrays.asList(6D, 17D, 34D);
        assertThat(result, is(expected));
    }
    /*
     * Проверка логарифмическрй функции
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Functions function = new Functions();
        List<Double> result = function.diapason(1, 2, Math::log);
        List<Double> expected = Collections.singletonList(0D);
        assertThat(result, is(expected));
    }
}