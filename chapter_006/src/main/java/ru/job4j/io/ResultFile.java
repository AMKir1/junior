package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 0.1. FileOutputStream. [#252488]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ResultFile {
    public static void main(String[] args) {

        StringBuilder matr = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                matr.append(i * j).append("\t");
            }
            matr.append(System.lineSeparator());
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("result.txt")
                ))) {
            out.write(matr.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
