package ru.job4j.memstart;

public interface UserAction {

	int key();
	void execute(Input input, MemTracker tracker) throws Exception;
	String info();
}