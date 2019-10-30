package test.java.ru.job4j.school;
/**
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Фильтрация учеников. [#110058]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import main.java.ru.job4j.school.Student;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolTest {
    /**
     * Проверка распределения студентов в класс А в зависимости от баллов
     */
    @Test
    public void whenAllocationStudentsAClassResults() {
        List<Student> students = new ArrayList<>();
        students.add(new Student( 100));
        students.add(new Student( 75));
        students.add(new Student( 65));
        students.add(new Student( 49));
        students.add(new Student( 46));
        students.add(new Student( 49));

        List<Student> A = students.stream().filter(
                student -> student.score >= 70).collect(Collectors.toList());

        assertThat(2, is(A.size()));
        assertThat(100, is(A.get(0).score));
        assertThat(75, is(A.get(1).score));

    }
    /**
     * Проверка распределения студентов в класс Б в зависимости от баллов
     */
    @Test
    public void whenAllocationStudentsBClassResults() {
        List<Student> students = new ArrayList<>();
        students.add(new Student( 100));
        students.add(new Student( 75));
        students.add(new Student( 65));
        students.add(new Student( 49));
        students.add(new Student( 46));
        students.add(new Student( 49));

        List<Student> B = students.stream().filter(
                student -> student.score >= 50 && student.score < 70).collect(Collectors.toList());

        assertThat(1, is(B.size()));
        assertThat(65, is(B.get(0).score));
    }
    /**
     * Проверка распределения студентов в класс С в зависимости от баллов
     */
    @Test
    public void whenAllocationStudentsCClassResults() {
        List<Student> students = new ArrayList<>();
        students.add(new Student( 100));
        students.add(new Student( 75));
        students.add(new Student( 65));
        students.add(new Student( 49));
        students.add(new Student( 46));
        students.add(new Student( 49));

        List<Student> C = students.stream().filter(
                student -> student.score < 50).collect(Collectors.toList());

        assertThat(3, is(C.size()));
        assertThat(49, is(C.get(0).score));
        assertThat(46, is(C.get(1).score));
        assertThat(49, is(C.get(2).score));
    }
}