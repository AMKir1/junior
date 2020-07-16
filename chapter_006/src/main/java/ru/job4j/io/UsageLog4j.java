package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 1. Log4j. Логирование системы. [#95335]
 * Task: 2. Simple Loggin Facade 4 Java. [#268849]
 * Task: 3. Slf4j - вывод переменных. [#268852]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte value = 2;
        short age = 25;
        int height = 177;
        long weight = 80l;
        float salary = 2.5f;
        double cinema = 7D;
        boolean man = true;
        char symbol = '⅞';

        LOG.debug("Info value : {}, age : {}, height : {}, weight : {}, salary : {}, cinema : {}, man : {}, symbol : {}", value, age, height, weight, salary, cinema, man, symbol);
    }
}