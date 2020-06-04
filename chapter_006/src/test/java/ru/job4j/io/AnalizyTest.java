package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 2. Анализ доступности сервера. [#859]
 * Task: 3.0. Тестирование IO [#173905]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

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

    @Test
    public void whenPairWithoutCommentForTemporaryFolder() throws IOException {
        Analizy anal = new Analizy();
        File source = folder.newFile("server.log");
        File target = folder.newFile("unavailable.csv");
        StringBuilder sb = new StringBuilder();
            sb.append("200 10:56:01");
            sb.append(System.lineSeparator());
            sb.append("200 10:57:01");
            sb.append(System.lineSeparator());
            sb.append("400 10:58:01");
            sb.append(System.lineSeparator());
            sb.append("200 10:59:01");
            sb.append(System.lineSeparator());
            sb.append("500 11:01:02");
            sb.append(System.lineSeparator());
            sb.append("200 11:02:02");

        try (PrintWriter out = new PrintWriter(source)) {
            out.println(sb.toString());
        }

        anal.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder result = new StringBuilder();
        result.append("10:58:01;10:59:01;");
        result.append("11:01:02;11:02:02;");

        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }

        assertThat(rsl.toString(), is(result.toString()));
    };
}
