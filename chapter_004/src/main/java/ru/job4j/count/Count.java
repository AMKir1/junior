package ru.job4j.count;
import java.util.List;
import java.util.Optional;
/**
 * Chapter_004. Stream API.
 * Task: Stream API [#106993]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
public class Count {
    public Integer count(List<Integer> data) {
        Optional<Integer> result = data.stream().filter(o -> o % 2 == 0).map(x -> x * x).reduce((x, y) -> x + y);
        return result.orElse(null);
    }
}