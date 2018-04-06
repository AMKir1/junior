package ru.job4j.coffee;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Chapter_002. CoffeeMachine.
 * Task: Реализовать выдачу сдачи
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */

public class CoffeeMachineTest {

    @Test
    public void coinsTest() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = new int[]{99, 1, 2, 0};
        assertThat(result, is(coffeeMachine.toGiveChange(1000, 1)));
    }
}
