package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 2. Анализ доступности сервера. [#859]
 * Task: 3.0. Тестирование IO [#173905]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenPairWithoutComment() {
        Analizy anal = new Analizy();
        anal.unavailable("server.log", "unavailable.csv");
        StringJoiner sj = new StringJoiner(System.lineSeparator());
            sj.add("10:58:01;10:59:01;");
            sj.add("11:01:02;11:02:02;");
        assertThat(
                sj.toString(),
                is(anal.readFile("unavailable.csv")));
    }

    @Test
    public void whenPairWithoutCommentForTemporaryFolder() throws IOException {
        Analizy anal = new Analizy();
        File source = folder.newFile("./server.log");
        File target = folder.newFile("./unavailable.csv");

        StringJoiner sj = new StringJoiner(System.lineSeparator());
            sj.add("200 10:56:01");
            sj.add("200 10:57:01");
            sj.add("400 10:58:01");
            sj.add("200 10:59:01");
            sj.add("500 11:01:02");
            sj.add("200 11:02:02");

        try (PrintWriter out = new PrintWriter(source)) {
            out.println(sj.toString());
        }

        anal.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }

        String result = "10:58:01;10:59:01;" +
                "11:01:02;11:02:02;";
        assertThat(rsl.toString(), is(result));
    }
}
