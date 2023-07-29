package com.oops.staticBlock;
class Employee{
	private String name;
	private int empId;
	private static int counter;
	private static String companyName;
	// static block Execute only once (Loading of class)
	static
	{
		counter=1;
		companyName="NucleusTeq";
	}
	// instance block execute when a object created 
	{
		empId=counter++;
	}
	public Employee(String name) {
		this.name=name;
	}
	public Employee() {
		
	}
	public String getName() {
		return name;
	}
	public int getEmpId() {
		return empId;
	}
	public String getCompanyName() {
		return companyName;
	}
	@Override
	public String toString() {
		return "Employee[name="+name+" EmpId="+empId+" companyName="+companyName+"]";
	}
}
public class StaticBlockProgram {
	public static void main(String[] args) {
		Employee employee1= new Employee("John");
		System.out.println(employee1);
		Employee employee2 = new Employee("Smith");
		System.out.println(employee2);
		
		
	}

}
