package ru.job4j.sqlstart;

public interface Input {
	String ask(String question);
	
	int ask(String question, int[] range);
}

