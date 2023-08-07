package com.basics_of_java.exercise04;

import java.util.Scanner;
public class OperatorExample2{
  public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
	 System.out.print("Enter the height :");
	 float height=sc.nextFloat();
	 System.out.print("Enter the Base :");
	 float base=sc.nextFloat();
	 double area=height*base/2;
	 System.out.println("Area of Triangle :"+area);
	 
  }
}