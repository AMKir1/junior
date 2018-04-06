package ru.job4j.search;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Chapter_003. Collection. Lite.
 * Task: Конвертация двумерного массива в ArrayList и наоборот [#10035]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class ConvertListTest {
    @Test
    /*
     * Testing converter to Array from List.
     */
    public void convertListToArr() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ConvertList convertToList = new ConvertList();
        List<Integer> list = convertToList.toList(arr);
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            result.add(i);
        }
        assertThat(list, is(result));
    }
    @Test
    /*
     * Testing converter to List from Array.
     */
    public void convertArrToList() {
        ConvertList convertToArr = new ConvertList();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            list.add(i);
        }
        int[][] arr = convertToArr.toArray(list, 2);
        int[][] result = {{0, 1, 2, 3, 4 }, {5, 6, 7, 8, 0}};
        assertThat(arr, is(result));
    }

    @Test
    /*
     * Testing converter list of arrays to one list.
     */
    public void convertArrListToList() {
        ConvertList convertToListFromListWithArr = new ConvertList();
        int[] array1 = new int[]{1, 2};
        int[] array2 = new int[]{3, 4, 5};
        List<int[]> list = new LinkedList<>();
        list.add(array1);
        list.add(array2);
        List<Integer> correct = new LinkedList<>();
        List<Integer> result = convertToListFromListWithArr.convert(list);
        for (int i = 1; i < 6; i++) {
            correct.add(i);
        }
        assertThat(correct, is(result));
    }
}
