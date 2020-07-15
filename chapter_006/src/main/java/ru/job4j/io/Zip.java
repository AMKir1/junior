package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 5.2. Архивировать проект [#861]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) throws IOException  {
        Files.deleteIfExists(target.toPath());
        try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(Files.createFile(target.toPath())))) {
                    sources.forEach(file -> {
                        ZipEntry zipEntry = new ZipEntry(String.valueOf(file.toPath()));
                        try {
                            zs.putNextEntry(zipEntry);
                            zs.closeEntry();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<File> searchFiles(ArgZip argZip) throws IOException {
        SearchFiles sf = new SearchFiles(new File(argZip.directory()), argZip.exclude());
        Files.walkFileTree(sf.getFile().toPath(), sf);
        List<File> listFiles = new ArrayList<>();
        for (Path p : sf.getPaths()) {
            listFiles.add(p.toFile());
        }
        return listFiles;
    }

    public static void main(String[] args) throws IOException {
        new Zip().packSingleFile(
                new File("./chapter_005/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
        ArgZip argZip = new ArgZip(args);
        new Zip().packFiles(searchFiles(argZip), new File(argZip.output()));
    }
}
