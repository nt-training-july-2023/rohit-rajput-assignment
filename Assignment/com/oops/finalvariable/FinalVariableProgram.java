package com.oops.finalvariable;

class Circle{
	public final float pi=3.14f; 
	public double area(double radius) {
		return pi*radius*radius;
	}
	public double perimeter(double radius) {
		return 2*pi*radius;
	}
}
public class FinalVariableProgram {
	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println("Area of circle :"+circle.area(5));
		System.out.println("Area of circle :"+circle.perimeter(6.5));
	}

}
