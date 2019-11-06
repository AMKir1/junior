package ru.job4j.search;
/*
 * Chapter_003. Collection. Lite.
 * Local-Variable Type Inference [#70626]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("tr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}
