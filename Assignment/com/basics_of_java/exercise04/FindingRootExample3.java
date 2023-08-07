package com.basics_of_java.exercise04;

import java.util.Scanner;
public class FindingRootExample3{
  public static void main(String args[]){
     Scanner sc=new Scanner(System.in);
	 System.out.print("Enter the value of a :");
     double a=sc.nextDouble();
	 System.out.print("Enter the value of b :");
     double b=sc.nextDouble();
	 System.out.print("Enter the value of c :"); 
	 double c=sc.nextDouble();
	 double root1;
	 double root2;
	 double D=(b*b)-(4*a*c);
	 if(D<0){
	    root1=-b/(2*a);
		root2=Math.sqrt(-D)/2*a;
	 }
	 else if(D==0){
	   root1=root2=-b/(2*a);
	 }
	 else{
	 root1=(-b + Math.sqrt(D))/2*a;
	 root2=(-b - Math.sqrt(D))/2*a;
	 
	 }
	 System.out.print("Root1 :"+root1+ ", Root2 :"+root2);
  }
}