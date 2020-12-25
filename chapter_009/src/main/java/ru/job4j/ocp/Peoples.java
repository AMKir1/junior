package ru.job4j.ocp;
/*
 * Chapter_009. OOD [#143].
 * Task: 3 примера нарушений принципа OCP. [#4914].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
import java.util.List;

public class Peoples {

    private static class Girl {
        public String getGender() {
            return "female";
        }
    }

    private static class Boy extends Girl {

    }

    public static void main(String[] args) {
        List<Girl> girls = List.of( new Girl(), new Boy());
        girls.forEach(p -> System.out.println(p.getGender()));
    }

}
