package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 0.2. FileInputStream [#4898]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("input.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
