package ru.job4j.pools;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 4. CompletableFuture[361626#453882].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RolColSum {
    public static class Sums {
        private int rowSum;
        private int colSum;

        @Override
        public String toString() {
            return "Sums{"
                    + "rowSum=" + rowSum
                    + ", colSum=" + colSum + '}';
        }
    }

    public static Sums[] sum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Sums[] result = new Sums[n];
        for (int i = 0; i < n; i++) {
            result[i] = new Sums();
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < m; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            result[i].rowSum = rowSum;
            result[i].colSum = colSum;
        }
        return result;
    }

    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        int n = matrix.length;
        Sums[] sums = new Sums[n];
        Map<Integer, CompletableFuture<Sums>> futures = new HashMap<>();
        for (int i = 0; i < n; i++) {
            futures.put(i, getTask(matrix, i));
        }
        for (Integer key : futures.keySet()) {
            sums[key] = futures.get(key).get();
        }
        return sums;
    }

    public static CompletableFuture<Sums> getTask(int[][] data, int i) {
        return CompletableFuture.supplyAsync(() -> {
            int m = data[0].length;
            int sumRow = 0;
            int sumCol = 0;
            for (int j = 0; j < m; j++) {
                sumRow += data[i][j];
                sumCol += data[j][i];
            }
            Sums sums = new Sums();
            sums.rowSum = sumRow;
            sums.colSum = sumCol;
            return sums;
        });
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
//
//        Arrays.stream(sum(matrix)).forEach(System.out::println);
//        Arrays.stream(asyncSum(matrix)).forEach(System.out::println);
//    }
}
