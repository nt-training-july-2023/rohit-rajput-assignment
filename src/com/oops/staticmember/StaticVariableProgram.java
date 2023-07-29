package com.oops.staticmember;
class Student{
	private int id;
	private String name;
	private static String schoolName;
	static {
		schoolName="SICA school";
	}
	public static void details(Student student) {
		System.out.println("Id= "+student.id+" Name= "+student.name+" SchoolName= "+student.schoolName);
	}
	public Student() {
		
	}
	public Student(int id ,String name) {
		this.id = id;
		this.name=name;
	}
	
}
public class StaticVariableProgram {
	public static void main(String[] args) {
		Student student = new Student(21,"Krishna");
		student.details(student);
	}

}
