package com.exception.customexception;

import java.util.InputMismatchException;
import java.util.Scanner;

class InvalidDimensionException extends RuntimeException{
	public InvalidDimensionException(String message) {
		super(message);
	}
	public InvalidDimensionException() {
		
	}
}
class Rectangle{
	public double area(double width , double length) {
		return width*length;
	}
}
public class Rectangleprogram {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		double width;
		double length;
		System.out.print("Enter the width of Rectangle :");
		try{
			 width=sc.nextDouble();
		     System.out.print("Enter the length of Rectangle :");
		     length=sc.nextDouble();
		     if(length<=0|| width<=0) {
		    	 throw new InvalidDimensionException("Width or length can't be zero");
		     }
		}
		catch(InputMismatchException exception) {
			throw new InvalidDimensionException("Invalid value entered");
		}
		double area=new Rectangle().area(width, length);
		System.out.println("Area of Rectangle :"+area);
		
	
	}
}
