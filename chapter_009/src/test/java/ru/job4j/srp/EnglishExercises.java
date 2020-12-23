package ru.job4j.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: Придумать 3 примера на нарушение принципа SRP [#4913].
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
/**
 * Class for English language exercises.
 */
public class EnglishExercises implements Exercises<ExerciseWord> {
    /**
     * Method of starting the program.
     * @param args - args.
     */
    public static void main(String[] args) {
        System.out.println("Start to learn English!");
    }

    /**
     * Method of extracting exercises for learning words.
     * @param exerciseId - Exercise id to get the exercise.
     * @return ExerciseWord.
     */
    @Override
    public ExerciseWord getExercise(int exerciseId) {
        return null;
    }

    /**
     * Method of adding english words to db.
     * @param exerciseWord - Any word.
     * @return boolean value.
     */
    @Override
    public boolean add(ExerciseWord exerciseWord) {
        return false;
    }

    /**
     * Method to output the word and its translation.
     * @param exerciseWord - Object of word.
     * @return String.
     */
    @Override
    public String toString(ExerciseWord exerciseWord) {
        return null;
    }
}
