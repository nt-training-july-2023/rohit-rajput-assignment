package com.exception.customexception;

import java.util.InputMismatchException;
import java.util.Scanner;

class NotEvenNumberException extends RuntimeException {

	public NotEvenNumberException() {
	}

	public NotEvenNumberException(String message) {
		super(message);
	}
}

public class EvenNumberProgram {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number :");
		int isEven = 0;
		try {
			isEven = scanner.nextInt();
		} catch (InputMismatchException e) {
			throw new NotEvenNumberException("you entered a wrong value");
		}
		if (isEven % 2 != 0) {
			throw new NotEvenNumberException(" Number is odd");
		}
		System.out.println("Number is Even");
	}

}
