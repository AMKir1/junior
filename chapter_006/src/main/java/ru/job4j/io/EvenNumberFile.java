package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 0.2. FileInputStream [#4898]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                    text.append((char) read);
            }

            String[] lines = text.toString().split(System.lineSeparator());
            text.delete(0, text.length());
            for (String line : lines) {
                if (Integer.parseInt(line) % 2 == 0) {
                    text.append(line + " - четное\n");
                } else {
                    text.append(line + " - нечетное\n");
                }
            }
            System.out.println(text);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
