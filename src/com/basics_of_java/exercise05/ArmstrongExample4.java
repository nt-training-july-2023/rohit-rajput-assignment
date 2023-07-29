package com.basics_of_java.exercise05;

import java.util.Scanner;
public class ArmstrongExample4{
   public static void main(String args[]){
       Scanner sc= new Scanner(System.in);
	   System.out.print("Enter a number :");
	   int n=sc.nextInt();
	   int a=n;
	   int b=0;
	   int sum=0;
	   while(a!=0){
	   b=a%10;
	   sum+=b*b*b;
	   a=a/10;
	}
	   if(n==sum)
	      System.out.print("Number is Armstrong");
	   else
	      System.out.print("Number is not Armstrong");
	  
   }
}