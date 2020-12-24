package ru.job4j.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: Придумать 3 примера на нарушение принципа SRP [#4913].
 * Разработайте класс для поиска максимального и минимального элемента по критерию java.util.Comparator.
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */
/**
 * Class describing words for exercises.
 */
public class ExerciseWord {
    /**
     * English word.
     */
    public String word;
    /**
     * Translate.
     */
    public String translate;

    /**
     * Designer.
     * @param word - English word.
     * @param translate - Translate.
     */
    public ExerciseWord(String word, String translate) {
        this.word = word;
        this.translate = translate;
    }

    /**
     * Get english word.
     * @return String.
     */
    public String getWord() {
        return word;
    }

    /**
     * Set english word.
     * @param word - english word.
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Get translate.
     * @return String.
     */
    public String getTranslate() {
        return translate;
    }

    /**
     * Set translate.
     * @param translate - Translate of word.
     */
    public void setTranslate(String translate) {
        this.translate = translate;
    }

    /**
     * Method for displaying the value of object parameters in text form.
     * @return String.
     */
    @Override
    public String toString() {
        return "ExerciseWord{" +
                "word='" + word + '\'' +
                ", translate='" + translate + '\'' +
                '}';
    }
}
