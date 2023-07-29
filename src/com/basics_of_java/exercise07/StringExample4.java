package com.basics_of_java.exercise07;

import java.util.Scanner;
public class StringExample4{
  public static void main(String args[]){
		String s="tradition";
	    String s1="deepak";
		String s2=s;
		String s3="tradition";
		// compares the content
		System.out.println(s.equals(s1));
		System.out.println(s.equals(s3));
		//compare ths reference
		System.out.println(s==s1);
		System.out.println(s==s2);
		
		//String pool
		System.out.println(s==s3);
  }
}