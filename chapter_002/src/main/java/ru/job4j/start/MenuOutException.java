package ru.job4j.start;

public class MenuOutException extends RuntimeException {
	
	public MenuOutException(String msg) {
		super(msg);
	}
}
/*
Все наследуют класс throw
а далее exception

hendel exception - которые можно обработать
наследуют просто exception
виртуальная машина настаивает, чтобы мы обрабатывали такие ошибки.
И такие ошибки надо обрабатывать

unhendel exception - (run time exception) нарушение логики
пример - выход за диапазон масива
		 ошибка деления на 0
		 
ERROR - ошибка в виртуальной ошибке
например
не хватет памяти
переполнение перезагрузки классов
что-то с библиатеками		 
*/