package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 4.1. Сканирование файловой системы. [#106929]
 * Task: 3.0. Тестирование IO [#173905]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFiles  implements FileVisitor<Path> {

    List<Path> pathes = new ArrayList<>();
    Path path;
    String ext;

    public SearchFiles(Path path, String ext) {
        this.path = path;
        this.ext = ext;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().getName().endsWith(ext)) {
            pathes.add(file);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public List<Path> getPaths() {
        return this.pathes;
    }
}