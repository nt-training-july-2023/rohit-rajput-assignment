package com.basics_of_java.exercise04;

import java.util.Scanner;
public class OperatorExample5{
  public static void main(String args[]){
    int x=10;
	int y=20;
	System.out.println(x&y);
	System.out.println(x|y);
	System.out.println(x^y);
	
	System.out.println(5&7);
	System.out.println(5|7);
	System.out.println(5^7);
	
	System.out.println(5<<2);//10100 => 20
	System.out.println(30>>2);//7    
  }
}