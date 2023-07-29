package com.basics_of_java.exercise05;

import java.util.Scanner;
public class LoopExample1{
  public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
	   System.out.print("Enter a number :");
	   int n=sc.nextInt();
	   int i=1;
	   do{
	      System.out.println(n*i);
		  i++;
	   }while(i<=10);
  }
}