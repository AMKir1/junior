package ru.job4j.sqlstart;

public interface UserAction {

	int key();
	void execute(Input input, Store tracker) throws Exception;
	String info();
}