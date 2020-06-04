package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 4.0. File [#252491]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */


import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("h:\\projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("file name : %s", file.getName()));
        System.out.println(String.format("size : %s", file.getTotalSpace()));
//        for (File subfile : file.listFiles()) {
//            System.out.println(subfile.getAbsoluteFile());
//        }
    }
}
