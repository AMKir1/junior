package ru.job4j.list;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack [#71474]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {

    SimpleStack stack = new SimpleStack();

    @Test
    public void pushElements() {
        assertThat(stack.toString(), is("Collection is empty"));
        stack.push("1");
        assertThat(stack.toString(), is("[ 1 ]"));
        stack.push("2");
        assertThat(stack.toString(), is("[ 2, 1 ]"));
        stack.push("3");
        assertThat(stack.toString(), is("[ 3, 2, 1 ]"));
    }

    @Test
    public void pollElements() {
        assertThat(stack.toString(), is("Collection is empty"));
        stack.push("1");
        assertThat(stack.toString(), is("[ 1 ]"));
        stack.push("2");
        assertThat(stack.toString(), is("[ 2, 1 ]"));
        stack.push("3");
        assertThat(stack.toString(), is("[ 3, 2, 1 ]"));

        assertThat(stack.poll(), is("3"));
        assertThat(stack.toString(), is("[ 2, 1 ]"));

    }
}
