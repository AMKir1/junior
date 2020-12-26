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
public class ReportFormatHTML implements ReportFormat {

    /**
     * Method for creating a document of HTML format.
     * @param data - employee data.
     * @return HTML Document.
     */
    @Override
    public String createDocument(String data) {
        StringBuilder html = new StringBuilder();
        html.append("<div id=\"employee\">").append(data).append("</div>").append(System.lineSeparator());
        return html.toString();
    }
}
