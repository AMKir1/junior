package ru.job4j.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: Придумать 3 примера на нарушение принципа SRP [#4913].
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */

/**
 * Interface for working with exercises.
 * @param <T> - Any exercise.
 */
public interface Exercises<T> {
    /**
     * Method for getting the desired exercise by its id.
     * @param exerciseId - Exercise id to get the exercise.
     * @return Exercise.
     */
    T getExercise(int exerciseId);

    /**
     * Method for adding the exercise to db.
     * @param t Adding an exercise to the database.
     * @return boolean value.
     */
    boolean add(T t);

    /**
     * Method for getting text information about an exercise.
     * @param t Exercise.
     * @return Information about the exercise.
     */
    String toString(T t);

}
