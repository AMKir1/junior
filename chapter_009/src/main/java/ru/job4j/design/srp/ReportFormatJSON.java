package ru.job4j.design.srp;
/*
 * Chapter_009. OOD [#143].
 * Task: Поддержка форматом XML, JSON, HTML в генераторе отчетов. [#851].
 * @author Andrei Kirillovykh (mailto:andykirill@gmail.com).
 * @version 1.
 */

/**
 * Class that implements the interface ReportFormat.
 */
public class ReportFormatJSON implements ReportFormat {

    /**
     * Method for creating a document of JSON format.
     * @param data - employee data.
     * @return JSON Document.
     */
    @Override
    public String createDocument(String data) {
        StringBuilder json = new StringBuilder();
        json.append("{ \"employee\" : ").append("\"" + data + "\"").append("}").append(System.lineSeparator());
        return json.toString();
    }
}
