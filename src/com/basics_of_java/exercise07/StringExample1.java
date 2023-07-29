package com.basics_of_java.exercise07;

import java.util.Scanner;
public class StringExample1{
  public static void main(String args[]){
        String s=new String("deepak");
	    System.out.println(s.hashCode());
		System.out.println(s);
		
		s="ricky";
		System.out.println(s.hashCode());
		System.out.println(s);
		
		StringBuilder s1=new StringBuilder("rohit");
		System.out.println(s1.hashCode());
		System.out.println(s1);
		
		s1.append("mohit");
		System.out.println(s1.hashCode());
		System.out.println(s1);
		
		
  }
}