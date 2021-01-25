package ru.job4j.io;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 1. Visibility. Общий ресурс вне критической секции[1102#453905].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 3.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.function.Predicate;

public class ParseFile {
    private static final Logger LOGGER = LoggerFactory.getLogger(ParseFile.class);

    private File file;

    public synchronized void setFile(File f) {
        file = f;
    }

    public synchronized File getFile() {
        return file;
    }

    public synchronized String getContent() throws IOException {
        return getContent(x -> true);
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        return getContent(x -> x < 0x80);
    }

    public synchronized String getContent(Predicate<Integer> pred) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) != -1) {
                if (pred.test(data)) {
                    sb.append((char) data);
                }
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return sb.toString();

    }

    public synchronized void saveContent(String content) throws IOException {
        try (OutputStream o = new FileOutputStream(file)) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
