package ru.job4j.matrix;
/*
 * Chapter_004. FP, Lambda, Stream API[#17951].
 * Преобразование матрицы чисел в список чисел. [#110228]
 * Преобразование List в Map. [#110226]
 * @author Kirillovykh Andrei (andykirill@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.List;

public class NumbMatrixTest {
    /*
     * Проверка метода преобразования матрицы в список
     */
    @Test
    public void whenAllocationStudentsAClassResults() {
        NumbMatrix numbMatrix = new NumbMatrix();

        Integer[][] matrix = {
                {1, 2},
                {3, 4}
        };

        List<Integer> listnumb = numbMatrix.getListByMatrix(matrix);

        assertThat(4, is(listnumb.size()));
    }
}