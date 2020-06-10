package ru.job4j.io;
/*
 * Chapter_006. Ввод-вывод[#633]
 * Task: 6. Кодировка. [#862]
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com)
 * @version 1
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chat {

    private boolean end = false;
    private boolean pause = false;
    private File computreAnswersFile;
    private File logFile;
    final List<String> computreAnswers = new ArrayList<>();
    final private List<String> logsList = new ArrayList<>();

    public Chat(File computreAnswersFile, File logFile) {
        this.computreAnswersFile = computreAnswersFile;
        this.logFile = logFile;
    }

    public void start() {
        setComputerAnswers();
        System.out.println("Привет. Начнем чат?");
        Scanner in = new Scanner(System.in);
        while (!this.end) {
            checkAnswer(in.nextLine());
            if (!this.pause) {
                computerAnswer();
            }
        }
    }

    public void checkAnswer(String userAnswer) {
        if (userAnswer.equals("закончить")) {
            this.logsList.add(userAnswer);
            writeLog();
            this.end = true;
        }
        if (userAnswer.equals("стоп")) {
            this.logsList.add(userAnswer);
            this.pause = true;
        }
        if (userAnswer.equals("продолжить")) {
            this.logsList.add(userAnswer);
            this.pause = false;
        }
    }

    public void computerAnswer() {
        if (this.end) {
            System.out.println("Пока");
        } else {
            System.out.println(this.computreAnswers.get((int) (Math.random() * this.computreAnswers.size())));
        }
    }

    public void setComputerAnswers() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.computreAnswersFile.getAbsolutePath()))) {
            read.lines().forEach(this.computreAnswers::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeLog() {
        try (PrintWriter out = new PrintWriter(
            new BufferedOutputStream(
                    new FileOutputStream(this.logFile)
            ))) {
            for (String log : this.logsList) {
                out.write(log + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}