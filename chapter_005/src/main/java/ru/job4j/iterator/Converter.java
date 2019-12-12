package ru.job4j.iterator;
/*
 * Chapter_005. Collections. Pro.[#146]
 * Task: 5.1.4. Создать convert(Iterator<Iterator>) [#152]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.Iterator;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> inIter = getInIter();

            public Iterator<Integer> getInIter() {
                Iterator<Integer> iter = it.next();
                while (it.hasNext()) {
                    if (!iter.hasNext()) {
                        iter = it.next();
                    } else {
                        break;
                    }
                }
                return iter;
            }

            public boolean hasNext() {
                return it.hasNext() || inIter.hasNext();
            }

            @Override
            public Integer next() {
                Integer result;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (inIter.hasNext()) {
                    result = inIter.next();
                } else {
                    inIter = it.next();
                    result = inIter.next();
                }
                return result;
            }
        };
    }
}
