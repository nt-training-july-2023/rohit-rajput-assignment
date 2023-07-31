package com.java_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class InvertContent {
  public static void main(String[] args) throws IOException {
	 
	File file = new File("D:/assignments-workspace/assignment/src/com/exception/filehandling/abc.txt"); 
	Scanner scanner = new Scanner(file);
	FileWriter fileWriter = new FileWriter("D:/assignments-workspace/assignment/src/com/exception/filehandling/cba.txt");
	Stack<String> stack = new Stack<String>();
	while(scanner.hasNextLine()) {
		String line =scanner.nextLine();
		System.out.println(line);
	    stack.push(line);
	}
	while(!stack.isEmpty()) {
		System.out.println(stack.peek());
		fileWriter.write(stack.pop());
	}
	fileWriter.close();
	System.out.println("Content inverted successfully...........");
	
}
}
