package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: Поддержка форматом XML, JSON, HTML в генераторе отчетов. [#851].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */

/**
 * Interface for the report format.
 */
public interface ReportFormat {

    /**
     * Method for creating a document of a specific format.
     * @param data - employee data.
     * @return the formatted document.
     */
    String createDocument(String data);
}
