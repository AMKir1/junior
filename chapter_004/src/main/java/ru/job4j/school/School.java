package main.java.ru.job4j.school;
/**
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Фильтрация учеников. [#110058]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict){
        List<Student> studClass = students.stream().filter(predict).collect(Collectors.toList());
        return studClass;
    }
}