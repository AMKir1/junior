package ru.job4j.start;

	import ru.job4j.models.*;
	import java.util.*;

public class ConsoleInput implements Input {
	private Scanner scanner = new Scanner(System.in);	
		
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
}