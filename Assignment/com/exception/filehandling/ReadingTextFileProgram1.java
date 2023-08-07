package com.exception.filehandling;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class ReadingTextFileProgram1 {
   public static void main(String[] args) {
	   Scanner sc= new Scanner(System.in);
	   System.out.print("Please Enter the File Name :");
	   String filename=sc.next();
	   File file = new File(filename);
	   FileInputStream fileInputStream;
	   DataInputStream inputStream ;
	try {
		fileInputStream = new FileInputStream("D:/Training/OOPs/Assignment/Execption/src/com/exception/filehandling/"+file);
	    inputStream = new DataInputStream(fileInputStream);
		byte[] arr = new byte[inputStream.available()];
	    int bytes = inputStream.read(arr);
	    for(byte b :arr) {
			System.out.print((char)b);
		}
	    
	}
     catch(FileNotFoundException e ) {
			System.out.println("File is not available");
	}
     catch(NullPointerException e1) {
		System.out.println("File is not available that by unable to read");
	} 
	catch (IOException e) {
		System.out.println("Unable to read the file");
	}
  }
}
