package com.java_io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContentCopy {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("D:/assignments-workspace/assignment/src/com/exception/filehandling/abc.txt");
		FileReader fileReader = new FileReader(file);
		FileWriter fileWriter = new FileWriter("D:/assignments-workspace/assignment/src/com/java_io/out.txt");
		
		while(fileReader.read()!=-1) {
			char ch = (char)fileReader.read();
			fileWriter.write(ch);
		}
		fileWriter.close();
		System.out.println("content copied successfully ...............");
		
		
	}

}
