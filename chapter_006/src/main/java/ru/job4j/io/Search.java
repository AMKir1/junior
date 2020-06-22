package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 4.1. Сканирование файловой системы. [#106929]
 * Task: 3.0. Тестирование IO [#173905]
 * Task: 5. Валидация параметров запуска. [#246865] v3
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Search  {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null.");
        } else {
            try {
                String ext = args[1];
                File start = new File(args[0]);
                search(start, ext).forEach(System.out::println);
            } catch (Exception e) {
                e.getMessage();
            }

        }
    }

    public static List<Path> search(File root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(root, ext);
        Files.walkFileTree(root.toPath(), searcher);
        return searcher.getPaths();
    }
}