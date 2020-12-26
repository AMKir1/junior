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
public class ReportFormatXML implements ReportFormat {

    /**
     * Method for creating a document of XML format.
     * @param data - employee.
     * @return XML Document.
     */
    @Override
    public String createDocument(String data) {
        StringBuilder xml = new StringBuilder();
        xml.append("<employee>").append(data).append("</employee>").append(System.lineSeparator());
        return xml.toString();
    }
}
