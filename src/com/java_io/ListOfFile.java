package com.java_io;

import java.io.File;

public class ListOfFile {
	public static void main(String[] args) {
		
	File file = new File("D:/assignments-workspace/assignment/src/com/exception/filehandling");
	if(file.isDirectory()) {
	String[] fileList = file.list();
	
	for(String name :fileList) {
		System.out.println(name);
	  }
    }
    else
    {
    	System.out.println("Directory doesn't exists.....");
    }
	
	
  }
}

