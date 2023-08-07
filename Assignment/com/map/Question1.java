package com.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
class Employee{
	private int id;
	private String name;
	public Employee() {}
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
public class Question1 {
	private static Map< Integer,String > map;
	public  void getEmployeeName(Map<Integer,String> map) {
		for(String value :map.values()) {
			System.out.println(value);
		}
	}
	public  void getEmployeeId(Map<Integer,String> map){
		for(Integer id:map.keySet()) {
			System.out.println(id);
		}
	}
	public  void addEmployee(Employee employee) {
		map.put(employee.getId(), employee.getName());
	}
public static void main(String[] args) {
	Question1 question1 = new Question1();
    map = new HashMap<Integer, String>();
    Employee employee = new Employee(1,"smith");
    Employee employee2 = new Employee(2,"John");
    Employee employee3 = new Employee(3,"shubman");
    Employee employee4 = new Employee(4,"rohit");
    Employee employee5 = new Employee(5,"shubman");
    question1.addEmployee(employee);
    question1.addEmployee(employee2);
    question1.addEmployee(employee3);
    question1.addEmployee(employee4);
    question1.addEmployee(employee5);
	question1.getEmployeeName(map);
	question1.getEmployeeId(map);
	
	
}
}
