package com.oops.polymor;

public class Adder {
	
	public static int add(int a,int b) {
		System.out.println("int parameter");
		return a+b;
	}
	public static  int add(int a,int b,int c) {
		return a+b+c;
	}
	public static float add(float a,float b) {
		System.out.println("float parameter");
		return a+b;
	}
	public static double add(double a,double b) {
		System.out.println("double parameter");
		return a+b;
	}

}
