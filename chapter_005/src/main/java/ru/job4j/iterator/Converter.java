package ru.job4j.iterator;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.1.4. Создать convert(Iterator<Iterator>) [#152]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 2
 */
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.Iterator;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> inIter = it.next();

            public boolean hasNext() {
                while (!inIter.hasNext()) {
                    if (!it.hasNext()) {
                        break;
                    }
                    inIter = it.next();
                }
                return inIter.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return inIter.next();
            }
        };
    }
}
