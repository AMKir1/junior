package ru.job4j.iterator;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.1.1. Итератор для двухмерного массива int[][] [#9539]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int i = 0;
    private int j = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > i && values[i].length - 1 >= j;
    }

    @Override
    public Object next() {
        Object result;
        if (hasNext()) {
            result = values[this.i][this.j];
            if (values[this.i].length - 1 > this.j) {
                this.j++;
            } else {
                this.i++;
                this.j = 0;
            }
            return result;
        } else {
            throw new NoSuchElementException();
        }
    }
}
