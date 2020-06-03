package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 2. Анализ доступности сервера. [#859]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    @Test
    public void whenPairWithoutComment() {
        Analizy anal = new Analizy();
        anal.unavailable("server.log", "unavailable.csv");
        StringBuilder sb = new StringBuilder();
                sb.append("10:58:01;10:59:01;");
                sb.append(System.lineSeparator());
                sb.append("11:01:02;11:02:02;");
        assertThat(
                sb.toString(),
                is(anal.readFile("unavailable.csv")));
    };
}
