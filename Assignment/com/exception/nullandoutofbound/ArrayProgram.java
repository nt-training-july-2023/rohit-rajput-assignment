package com.exception.nullandoutofbound;

import java.util.Scanner;

public class ArrayProgram {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 20, 30, 40, 50, 60, 70 };
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the index number:");
		int index = sc.nextInt();
		if (arr.length == 0) {
			throw new NullPointerException("Array is empty");
		} else if (index >= arr.length || index < 0) {
			throw new ArrayIndexOutOfBoundsException("index doesn't exist in Array");
		}

		System.out.println(arr[index]);
	}

}
