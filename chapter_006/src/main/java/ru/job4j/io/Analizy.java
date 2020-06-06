package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 2. Анализ доступности сервера. [#859]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.io.*;
import java.util.*;


public class Analizy {

    boolean error = false;

    public void unavailable(String source, String target) {

        final List<String> values = new ArrayList<>();

        try (BufferedReader read = new BufferedReader(new FileReader(source))) {

            read.lines().forEach(l -> {
                if (l.contains("400") || l.contains("500")) {
                    if (!this.error) {
                        values.add(l.split(" ")[1] + ";");
                        this.error = true;
                    }
                }

                if (l.contains("200") || l.contains("300")) {
                    if (this.error) {
                        values.add(l.split(" ")[1] + ";" + System.lineSeparator());
                        this.error = false;
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (String s : values) {
                out.write(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readFile(String filename) {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(filename))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}