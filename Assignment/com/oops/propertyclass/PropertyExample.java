package com.oops.propertyclass;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertyExample {
public static void main(String[] args) throws IOException {
	FileReader reader = new FileReader("D:/Training/Assignment/Assignment03/BasicsOfJava/src/Propertyclass/application.properties");
	Properties properties = new Properties();
	properties.load(reader);
	System.out.println(properties.getProperty("name"));

	System.out.println(properties.getProperty("nation"));
	properties.setProperty("city", "Indore");
	System.out.println(properties.getProperty("city"));

   }
}
