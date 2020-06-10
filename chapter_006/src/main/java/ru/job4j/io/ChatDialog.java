package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 6. Кодировка. [#862]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.File;

public class ChatDialog {
    public static void main(String[] args) {
        Chat chat = new Chat(new File(args[0]), new File(args[1]));
        chat.start();
    }
}