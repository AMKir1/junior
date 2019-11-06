package ru.job4j.school;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Фильтрация учеников. [#110058]
 * Преобразование List в Map. [#110226]
 * Stream API улучшения [#58167]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.2
 */
class Student implements Comparable<Student>  {
    private int score;
    private String surename;

    Student(String surename, int score) {
        this.surename = surename;
        this.score = score;
    }
    @Override
    public int compareTo(Student o) {
        return o.getScore();
    }

    public int getScore() {
        return score;
    }

    public String getSurename() {
        return surename;
    }
}