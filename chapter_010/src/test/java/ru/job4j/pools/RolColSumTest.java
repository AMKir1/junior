package ru.job4j.pools;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 4. CompletableFuture[361626#453882].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RolColSumTest {

    /**
     * When sum.
     */
    @Test
    public void whenSum() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Arrays.stream(RolColSum.sum(matrix)).forEach(s -> sb.append(s.toString()));
        sb.append("}");
        assertThat(sb.toString(), is("{Sums{rowSum=6, colSum=12}Sums{rowSum=15, colSum=15}Sums{rowSum=24, colSum=18}}"));
    }

    /**
     * When Async Sum.
     */
    @Test
    public void whenAsyncSum() throws InterruptedException, ExecutionException {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Arrays.stream(RolColSum.asyncSum(matrix)).forEach(s -> sb.append(s.toString()));
        sb.append("}");
        assertThat(sb.toString(), is("{Sums{rowSum=6, colSum=12}Sums{rowSum=15, colSum=15}Sums{rowSum=24, colSum=18}}"));
    }
}
