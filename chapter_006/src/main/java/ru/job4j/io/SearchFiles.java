package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 4.1. Сканирование файловой системы. [#106929]
 * Task: 3.0. Тестирование IO [#173905]
 * Task: 5. Валидация параметров запуска. [#246865]
 * Task: 5.2. Архивировать проект [#861]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFiles  implements FileVisitor<Path> {

    private List<Path> pathes = new ArrayList<>();
    private File file;
    private String ext;

    public SearchFiles(File file, String ext) {
        this.file = file;
        this.ext = ext;
    }

    public class ExtensionPredicate implements Predicate<File> {

        String extension;

        public ExtensionPredicate(String extension) {
            this.extension = extension;
        }

        @Override
        public boolean test(File file) {
            return file != null && file.getName().endsWith(extension);
        }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        ExtensionPredicate extensionPredicate = new ExtensionPredicate(ext);
        if (extensionPredicate.test(file.toFile())) {
            pathes.add(file.toAbsolutePath());
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }

    public List<Path> getPaths() {
        return this.pathes;
    }

    public File getFile() {
        return file;
    }

}