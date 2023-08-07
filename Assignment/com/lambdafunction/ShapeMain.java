package com.lambdafunction;

import java.util.Scanner;

interface Shape {
	double pi = 3.14;

	double area();
}

public class ShapeMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shape rectangle = () -> {
			System.out.println("Enter the values of rectangle........");
			System.out.println("Enter the value of length :");
			double length = scanner.nextDouble();
			System.out.println("Enter the value of width :");
			double width = scanner.nextDouble();
			return length * width;
		};
		Shape circle = () -> {
			System.out.println("Enter the values of circle........");
			System.out.println("Enter the value of radius :");
			double radius = scanner.nextDouble();
			return Shape.pi * radius * radius;
		};
		Shape triangle = () -> {
			System.out.println("Enter the values of triangle........");
			System.out.println("Enter the value of base :");
			double base = scanner.nextDouble();
			System.out.println("Enter the value of length :");
			double length = scanner.nextDouble();
			return (base * length) / 2;
		};
		Shape square = () -> {
			System.out.println("Enter the values of square........");
			System.out.println("Enter the value of side :");
			double side = scanner.nextDouble();
			return side * side;
		};

		Shape cube = () -> {
			System.out.println("Enter the values of cube........");
			System.out.println("Enter the value of side :");
			double side = scanner.nextDouble();
			return 6 * side * side;
		};

		Shape sphere = () -> {
			System.out.println("Enter the values of sphere........");
			System.out.println("Enter the value of radius :");
			double radius = scanner.nextDouble();
			return 4 * Shape.pi * radius * radius;
		};

		Shape cylinder = () -> {
			System.out.println("Enter the values of cylinder........");
			System.out.println("Enter the value of radius :");
			double radius = scanner.nextDouble();
			System.out.println("Enter the value of height :");
			double height = scanner.nextDouble();
			return (2 * Shape.pi * radius) * (radius + height);
		};
		System.out.println(rectangle.area());
		System.out.println(circle.area());
		System.out.println(triangle.area());
		System.out.println(square.area());
		System.out.println(cube.area());
		System.out.println(sphere.area());
		System.out.println(cylinder.area());
	}
}
