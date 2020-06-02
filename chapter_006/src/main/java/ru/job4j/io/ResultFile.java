package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 0.1. FileOutputStream. [#252488]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {

        StringBuilder matr = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                matr.append(i * j).append("\t");
            }
            matr.append("\n");
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(matr.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
