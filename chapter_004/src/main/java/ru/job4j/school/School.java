package ru.job4j.school;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Фильтрация учеников. [#110058]
 * Преобразование List в Map. [#110226]
 * Stream API улучшения [#58167]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.2
 */
import ru.job4j.addresslist.Address;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class School {

    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    Map<String, Student> listToMap(List<Student> students) {
        return students.stream().collect(
                Collectors.toMap(
                        Student::getSurename,
                        student -> student
                ));
    }

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .takeWhile(s -> s.getScore() > bound)
                .collect(Collectors.toList());
    }
}