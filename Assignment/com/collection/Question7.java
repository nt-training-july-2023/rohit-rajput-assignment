package com.collection;

import java.util.Comparator;
import java.util.TreeSet;

class Employee implements Comparable<Employee>{
     String name;
     int eid;
    
	public Employee() {
		super();
	}

	public Employee(String name, int eid) {
		super();
		this.name = name;
		this.eid = eid;
	}
    
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + "]";
	}

	@Override
	public int compareTo(Employee o) {
		int eid=this.eid;
		int eid2=o.eid;
		if(eid<eid2)
			return -1;
		else if(eid>eid2)
			return 1;
		else
			return 0;
	}
	
}
class MyComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		String s1 = o1.name;
		String s2 = o2.name;
		return s1.compareTo(s2);
	}
	
}
public class Question7 {
    public static void main(String[] args) {
    	Employee employee1=new Employee("Rohit",1);
    	Employee employee2=new Employee("Mohit",19);
    	Employee employee3=new Employee("Yash",10);
    	Employee employee4=new Employee("Anuj",7);
    	Employee employee5=new Employee("Radha",18);
    	TreeSet<Employee> t = new TreeSet<Employee>();
    	t.add(employee1);
    	t.add(employee2);
    	t.add(employee3);
    	t.add(employee4);
    	t.add(employee5);
    	System.out.println(t);
    	
    	TreeSet<Employee> t2 = new TreeSet<Employee>(new MyComparator());
    	t2.add(employee1);
    	t2.add(employee2);
    	t2.add(employee3);
    	t2.add(employee4);
    	t2.add(employee5);
    	System.out.println(t2);
	}
}
