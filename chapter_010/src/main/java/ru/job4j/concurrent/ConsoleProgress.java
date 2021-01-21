package ru.job4j.concurrent;
/*
 * Chapter_010. 1. Multithreading[171#453877].
 * Task: 3. Прерывание нити[1019#453895].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
public class ConsoleProgress implements Runnable{

    private String[] process = {"\\","|", "/"};

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Thread loading = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    for(int i = 0; i < process.length; i++) {
                        System.out.print("\r load: " + process[i]);
                        Thread.sleep(500);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        loading.start();
    }
}
