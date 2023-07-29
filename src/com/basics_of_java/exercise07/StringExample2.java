package com.basics_of_java.exercise07;

import java.util.Scanner;
public class StringExample2{
  public static void main(String args[]){
		String s="tradition";
		System.out.println(s.length());
		System.out.println(s.concat("al"));
		System.out.println(s);
		System.out.println(s.charAt(6));
		System.out.println(s.startsWith("t",0));
		System.out.println(s.startsWith("d"));
		System.out.println(s.endsWith("n"));
		System.out.println(s.indexOf('n'));
		System.out.println(s.replace('t','r'));
		System.out.println(s);
  }
}