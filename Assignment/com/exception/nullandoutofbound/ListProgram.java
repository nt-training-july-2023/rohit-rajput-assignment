package com.exception.nullandoutofbound;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ListProgram {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "banana", "orange", "chair", "pen");
		// List<String > list=Arrays.asList();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the index number:");
		int index = sc.nextInt();
		if (list.size() == 0) {
			throw new NullPointerException("List is empty");
		} else if (index >= list.size() || index < 0) {
			throw new ArrayIndexOutOfBoundsException("index doesn't exist in list");
		}
    
		System.out.println(list.get(index));
	}

}
