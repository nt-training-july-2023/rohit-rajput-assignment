package com.basics_of_java.exercise05;

import java.util.Scanner;
public class ReverseExample5{
   public static void main(String args[]){
       Scanner sc= new Scanner(System.in);
	   System.out.print("Enter a number :");
	   int n=sc.nextInt();
	   int rev=0;
	   int a=n;
	   int b=0;
	   while(a!=0){
	   b=a%10;
	   rev=(rev*10)+b;
	   a/=10;
	   }
	   System.out.print("Reverse :"+rev);
	  
	  
   }
}