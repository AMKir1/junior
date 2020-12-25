package ru.job4j.ocp;
/*
 * Chapter_009. OOD [#143].
 * Task: 3 примера нарушений принципа OCP. [#4914].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.List;

public class Phones {

    private interface Callable {
        String call();
    }

    private static class MobilePhone implements Callable {
        @Override
        public String call(){
            return "Ding-Ding";
        }
    }

    private static class ToyPhone extends MobilePhone {

    }

    private static class HousePhone extends ToyPhone {

    }

    public static void main(String[] args) {
        List<Callable> callables = List.of(new ToyPhone(), new MobilePhone(), new HousePhone());
        callables.forEach(p -> System.out.println(p.call()));
    }


}
