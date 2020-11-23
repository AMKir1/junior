package ru.job4j.io.cache;
/*
 * Chapter_008. Garbage Collection [#147]
 * Task: 4.1 Реализации кеша на SoftReference [#1592]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

import org.junit.Test;
import ru.job4j.gc.cache.CacheTextFiles;
import ru.job4j.gc.cache.Content;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CacheTextFilesTest {

    Map<String, SoftReference<Content>> cacheMap = new HashMap<>();
    CacheTextFiles cache = new CacheTextFiles(cacheMap);

    /*
     * Тест. Запись файла в кэш, если в кэше не найден файл по ключу.
     */
    @Test
    public void whenSetFirstFile() {
        assertThat(cache.size(), is(0));
        String filename = "../test1.txt";
        String dataFromCache = cache.getDataFromCache(filename);
        assertThat(cache.size(), is(1));
        assertThat(dataFromCache, is("test1"));
    }

    /*
     * Тест. Получение данных из кэша, если в кэше есть файл по ключу, без чтения файла.
     */
    @Test
    public void whenGetFirstFile() {
        assertThat(cache.size(), is(0));
        String filename = "../test1.txt";
        String dataFromCache = cache.getDataFromCache(filename);
        assertThat(cache.size(), is(1));
        assertThat(dataFromCache, is("test1"));

        String sameDataFromCache = cache.getDataFromCache(filename);
        assertThat(cache.size(), is(1));
        assertThat(sameDataFromCache, is("test1"));

    }

    /*
     * Тест. Работа с несколькими файлами из одной дирректории.
     */
    @Test
    public void whenWorkWithSomeFiles() {
        assertThat(cache.size(), is(0));
        String filename1 = "../test1.txt";
        String filename2 = "../test2.txt";
        String filename3 = "../test3.txt";
        String dataFromCache1 = cache.getDataFromCache(filename1);
        assertThat(cache.size(), is(1));
        assertThat(dataFromCache1, is("test1"));

        String sameDataFromCache1 = cache.getDataFromCache(filename1);
        assertThat(cache.size(), is(1));
        assertThat(sameDataFromCache1, is("test1"));

        String dataFromCache2 = cache.getDataFromCache(filename2);
        assertThat(cache.size(), is(2));
        assertThat(dataFromCache2, is("test2"));

        String dataFromCache3 = cache.getDataFromCache(filename3);
        assertThat(cache.size(), is(3));
        assertThat(dataFromCache3, is("test3"));

        String sameDataFromCache2 = cache.getDataFromCache(filename2);
        assertThat(cache.size(), is(3));
        assertThat(sameDataFromCache2, is("test2"));

        String sameDataFromCache3 = cache.getDataFromCache(filename3);
        assertThat(cache.size(), is(3));
        assertThat(sameDataFromCache3, is("test3"));

    }
}