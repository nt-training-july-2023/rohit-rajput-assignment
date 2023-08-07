package com.basics_of_java.exercise07;

import java.util.Scanner;
public class StringExample3{
  public static void main(String args[]){
		String s="tradition";
		byte ch[]=s.getBytes();
		for(int i=0;i<ch.length;i++){
			System.out.print((char)ch[i]+" ");
		}
		System.out.println();
		System.out.println(s.equals("train"));
		System.out.println(s.equals("traditional"));
		
		System.out.println(s.substring(1));
		
		System.out.println(s.lastIndexOf('t'));
		char ch1[] =s.toCharArray();
		System.out.println(ch1[5]);
  }
}