package ru.job4j.patterns;

public class StrategyPattern {
	
   public static void main(String[] args) {
      Shape shape = new Square();		
      System.out.println(shape.draw());

      shape = new Triangle();				
      System.out.println(shape.draw());
	  }
}