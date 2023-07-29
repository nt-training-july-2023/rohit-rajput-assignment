package com.oops.polymor;

import java.io.BufferedReader;

public class Multiply {
	public static int multiply(int a,int b) {
		System.out.println("int parameter");
		return a*b;
	}
	public static  int multiply(int a,int b,int c) {
		return a*b*c;
	}
	public static float multiply(float a,float b) {
		System.out.println("float parameter");
		return a*b;
	}
	public static double multiply(double a,double b) {
		System.out.println("double parameter");
		return a*b;
	}
	

}

