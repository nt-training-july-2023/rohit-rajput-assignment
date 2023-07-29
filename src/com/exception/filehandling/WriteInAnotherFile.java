package com.exception.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteInAnotherFile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the name of source file :");
		String source = scanner.next();
		File file1 = new File("D:/Training/OOPs/Assignment/Execption/src/com/exception/filehandling/" + source);
		Scanner scanner2 = null;
		try {
			scanner2 = new Scanner(file1);
		} catch (FileNotFoundException e) {
			System.out.println("Source file is not available");
			return;
		}
		
		
		System.out.print("Enter the name of destination file :");
		String destination = scanner.next();
		File file2 = new File("D:/Training/OOPs/Assignment/Execption/src/com/exception/filehandling/" + destination);
		try {
			if (file2.createNewFile()) {
				System.out.println("New file is created");
			}
			if (file2.canWrite()) {

				while (scanner2.hasNextLine()) {
					String line = scanner2.nextLine();
					FileWriter fileWriter = new FileWriter(file2);
					fileWriter.write(line);
				}
				System.out.println("Content copied successfully");

			} else {
				System.out.println("File is not Writable");
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
