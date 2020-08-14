package ru.job4j.memstart;

public interface Input {
	String ask(String question);
	
	int ask(String question, int[] range);
}

