package com.lambdafunction;

import java.util.Scanner;

interface ReplaceCharacter{
	String replcae(String input);
}
public class ReplaceVowels {
     public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter value :");
	    String input = scanner.next();
	    ReplaceCharacter replaceCharacter = (str)->str.replaceAll("[AEIOUaeiou]", "#");
	    input =replaceCharacter.replcae(input);
	    System.out.println(input);
    }
}
