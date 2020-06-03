package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 1. Читаем файл конфигурации [#858]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Andrei Kirillovykh")
        );
    }
}
