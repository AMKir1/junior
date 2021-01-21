package ru.job4j.concurrent;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Прерывание нити[1019#453895].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class ConsoleProgressMain {
    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(1); /* симулируем выполнение параллельной задачи в течение 1 секунды. */
        progress.interrupt(); //
    }
}
