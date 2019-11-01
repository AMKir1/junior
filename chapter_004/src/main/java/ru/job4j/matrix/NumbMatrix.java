package ru.job4j.matrix;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Преобразование матрицы чисел в список чисел. [#110228]
 * Преобразование List в Map. [#110226]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NumbMatrix {
    List<Integer> getListByMatrix(Integer[][] matrix ) {
        return Stream.of(matrix).flatMap(Stream::of).collect(Collectors.toList());
    }
}
