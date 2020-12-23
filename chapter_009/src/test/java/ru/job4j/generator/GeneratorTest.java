package ru.job4j.generator;
/*
 * Chapter_009. OOD [#143]
 * Task: Шаблонизатор. [#855]
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GeneratorTest {


    Map<String, String> map = new HashMap<>();
    Generator generator = (template, args) -> "I am " + args.get("name") + ", Who are " + args.get("subject") + "?";

    @Test
    public void whenNoProblems() {
        map.put("name", "Andrew");
        map.put("subject", "you");
        String result = generator.produce("I am ${name}, Who are ${subject}?", map);
        assertThat(result, is("I am Andrew, Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoMap() {
        generator.produce("I am ${name}, Who are ${subject}?", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoKeys() {
        generator.produce("I am ${name}, Who are ${subject}?", map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNoTemplate() {
        map.put("name", "Andrew");
        map.put("subject", "you");
        generator.produce(null, map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasKeyAndGeneratorHasNotKey() {
        map.put("name", "Andrew");
        map.put("subject", "you");
        map.put("newkey", "newkey");
        generator.produce("I am ${name}, Who are ${subject}?", map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMapHasNotKeyAndGeneratorHasKey() {
        map.put("name", "Andrew");
        map.put("subject", "you");
        generator.produce("I am ${name}, Who are ${subject}? I'm glad to see ${subject_2}!", map);
    }

}