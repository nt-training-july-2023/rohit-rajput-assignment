package com.exception.customexception;

import java.util.Scanner;

class InvalidPasswordException extends RuntimeException {

	public InvalidPasswordException() {
	}

	public InvalidPasswordException(String message) {
		super(message);
	}
}

public class InvalidPassword {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please Enter thr Password :");
		boolean isChar = true;
		boolean isNum = true;
		String password = scanner.next();
		if (password.length() < 8) {
			throw new InvalidPasswordException("password is too short");
		}
		int i = 0;
		while ((isNum || isChar) && i < password.length()) {
			byte value = (byte) password.charAt(i);
			if (value >= 48 && value < 58) {
				isNum = false;
			} else {
				isChar = false;
			}
			i++;
		}
		if (isChar == true || isNum == true) {
			throw new InvalidPasswordException("Password must be combination of number and character");
		}
		System.out.println("Correct password......");

	}
}
