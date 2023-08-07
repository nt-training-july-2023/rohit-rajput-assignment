package com.oops.polymor;

public class Substractor {
	public static int subs(int a,int b) {
		System.out.println("int parameter");
		return a-b;
	}
	public static  int subs(int a,int b,int c) {
		return a-b-c;
	}
	public static float subs(float a,float b) {
		System.out.println("float parameter");
		return a-b;
	}
	public static double subs(double a,double b) {
		System.out.println("double parameter");
		return a-b;
	}

}
