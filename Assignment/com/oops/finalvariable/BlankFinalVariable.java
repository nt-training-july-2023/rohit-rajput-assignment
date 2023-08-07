package com.oops.finalvariable;
class Employee{
	private String name;
	public final String empId;
	public static final String companyName;
	static {
		companyName="NucluesTeq";
	}
	public Employee(String empId,String name){
		this.empId=empId;
		this.name=name;
	}
	public Employee(String name) {
		this.empId="EMP0000";
		this.name=name;
	}
	public Employee() {
		this.empId="EMP0000";
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empId=" + empId + ", companyName="+companyName+"]";
	}
	
}
public class BlankFinalVariable {
	public static void main(String[] args) {
		Employee employee = new Employee("EMP0001","Joe");
		System.out.println(employee);
		Employee employee2 = new Employee("EMP0002","Ben");
		System.out.println(employee2);
	}
}
