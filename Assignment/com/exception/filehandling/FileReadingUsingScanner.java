package com.exception.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingUsingScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter File Name :");
		String fileName = scanner.next();
		File file = new File("D:/Training/OOPs/Assignment/Execption/src/com/exception/filehandling/" + fileName);
		if (file.canRead()) {
			Scanner scanner2 = null;
			try {
				scanner2 = new Scanner(file);
				while (scanner2.hasNextLine()) {
					System.out.println(scanner2.nextLine());
				}
			} catch (FileNotFoundException e) {
				System.out.println("File not avaiable");
			}
		} else {
			System.out.println("File is not readable");
		}

	}
}
