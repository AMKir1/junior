package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                result.add(j);
            }
        }
        return result;
    }



    public int[][] toArray (List<Integer> list, int rows) {
        int step = 0;
        int cols = list.size() % rows == 0 ? list.size() / rows : (list.size() / rows) + 1;
        int [][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (step < list.size()) {
                    if (list.get(step) != null) {
                        array[i][j] = list.get(step);
                    } else {
                        array[i][j] = 0;
                    }
                } else {
                    array[i][j] = 0;
                }
                step++;
            }
        }
        return array;
    }
}
