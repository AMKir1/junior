package ru.job4j.iterator;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.1.2. Создать итератор четные числа [#150]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {

    private final int[] values;
    private int i = 0;

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int k = this.i; k < this.values.length; k++) {
            result = isEven(k);
            this.i = k;
            if (result) {
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int result = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        result = this.values[this.i];
        this.i++;
        return result;
    }

    public boolean isEven(int k) {
        return this.values[k] % 2 == 0;
    }
}
