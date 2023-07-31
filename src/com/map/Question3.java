package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Question3 {
	private static Map<Integer,String> map;
	private static int threshold; 
	public static void addEmployee(Employee employee) {
		map.put(employee.getId(), employee.getName());
	}
	public static void printDetails(Map<Integer, String> map) {
		for(Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		if(map.size()>=threshold) {
			map.clear();
			System.out.println("Map cleared .........");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the threshold size :");
		threshold=scanner.nextInt();
	    map = new HashMap<Integer, String>(threshold);
		addEmployee(new Employee(1,"john"));
		addEmployee(new Employee(2,"joe"));
		addEmployee(new Employee(3,"Shyam"));
		addEmployee(new Employee(4,"gita"));
		addEmployee(new Employee(5,"Soham"));
		addEmployee(new Employee(6,"rohan"));
		printDetails(map);
		System.out.println(map);
		
		
		
	}
}
