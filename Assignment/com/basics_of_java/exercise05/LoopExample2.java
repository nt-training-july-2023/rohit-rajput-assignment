package com.basics_of_java.exercise05;

import java.util.Scanner;
public class LoopExample2{
  public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
	   System.out.print("Enter the Value of n :");
	   int n=sc.nextInt();
	   int sum=0;
	   for(int i=1;i<=n;i++){
	       sum+=i;
	   }
	   
	   System.out.print("Sum of First "+n+" numbers : "+sum);
	   
  }
}