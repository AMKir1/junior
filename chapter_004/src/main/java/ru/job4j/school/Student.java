package main.java.ru.job4j.school;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Фильтрация учеников. [#110058]
 * Преобразование List в Map. [#110226]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Student {
    public int score;
    public String surename;

    public Student(String surename, int score){
        this.surename = surename;
        this.score = score;
    }
}