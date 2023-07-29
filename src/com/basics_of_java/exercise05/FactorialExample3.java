package com.basics_of_java.exercise05;

import java.util.Scanner;
public class FactorialExample3{
   public static int fact(int n){
      if(n<=1){
	     return n;
	  }
	  return n*fact(n-1);
   }
   public static void main(String args[]){
       Scanner sc= new Scanner(System.in);
	   System.out.print("Enter a number :");
	   int n=sc.nextInt();
	   System.out.print("Factorial of "+n+" is : "+fact(n));
	   
   }
}