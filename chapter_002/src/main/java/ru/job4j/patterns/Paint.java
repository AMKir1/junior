package ru.job4j.patterns;

public class Paint {
   private Shape shape;

   public Paint() {
      this.shape = shape;
   }

   public void draw(Shape shape) {
      System.out.println(shape.draw());
   }
}