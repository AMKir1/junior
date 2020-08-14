package ru.job4j.mem_start;

public interface UserAction {

	int key();
	void execute(Input input, MemTracker tracker) throws Exception;
	String info();
}