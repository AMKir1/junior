package ru.job4j.school;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Фильтрация учеников. [#110058]
 * Преобразование List в Map. [#110226]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.2
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SchoolTest {
    /**
     * Проверка распределения студентов в класс А в зависимости от баллов
     */
    @Test
    public void whenAllocationStudentsAClassResults() {
        List<Student> students = new ArrayList<>();
        School school = new School();
        students.add(new Student("Иванов", 100));
        students.add(new Student("Иванов", 75));
        students.add(new Student("Иванов", 65));
        students.add(new Student("Иванов", 49));
        students.add(new Student("Иванов", 46));
        students.add(new Student("Иванов", 49));

        List<Student> classA = school.collect(students, student -> student.score >= 70);

        assertThat(2, is(classA.size()));
        assertThat(100, is(classA.get(0).score));
        assertThat(75, is(classA.get(1).score));

    }
    /**
     * Проверка распределения студентов в класс Б в зависимости от баллов
     */
    @Test
    public void whenAllocationStudentsBClassResults() {
        List<Student> students = new ArrayList<>();
        School school = new School();
        students.add(new Student("Иванов", 100));
        students.add(new Student("Иванов", 75));
        students.add(new Student("Иванов", 65));
        students.add(new Student("Иванов", 49));
        students.add(new Student("Иванов", 46));
        students.add(new Student("Иванов", 49));

        List<Student> classB = school.collect(students, student -> student.score >= 50 && student.score <= 70);

        assertThat(1, is(classB.size()));
        assertThat(65, is(classB.get(0).score));
    }
    /**
     * Проверка распределения студентов в класс С в зависимости от баллов
     */
    @Test
    public void whenAllocationStudentsCClassResults() {
        List<Student> students = new ArrayList<>();
        School school = new School();
        students.add(new Student("Иванов", 100));
        students.add(new Student("Иванов", 75));
        students.add(new Student("Иванов", 65));
        students.add(new Student("Иванов", 49));
        students.add(new Student("Иванов", 46));
        students.add(new Student("Иванов", 49));

        List<Student> classC = school.collect(students, student -> student.score < 50);

        assertThat(3, is(classC.size()));
        assertThat(49, is(classC.get(0).score));
        assertThat(46, is(classC.get(1).score));
        assertThat(49, is(classC.get(2).score));
    }
    /**
     * Проверка распределения студентов в Map
     */
    @Test
    public void whenStudentsInMapResults() {
        List<Student> students = new ArrayList<>();
        School school = new School();
        students.add(new Student("Иванов", 100));
        students.add(new Student("Петров", 75));
        students.add(new Student("Попов", 65));
        students.add(new Student("Сурков", 49));
        students.add(new Student("Степин", 46));
        students.add(new Student("Сергеев", 49));

        Map<String, Student> map = school.listToMap(students);

        assertThat(49, is(map.get("Сергеев").score));
    }
}