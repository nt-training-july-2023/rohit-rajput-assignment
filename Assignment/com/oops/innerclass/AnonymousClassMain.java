package com.oops.innerclass;
abstract class Employee{
	private String name;
	public Employee(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	abstract void role();
}
public class AnonymousClassMain {
	public static void main(String[] args) {
		Employee employee1 = new Employee("Sam") {
			@Override
			void role() {
				System.out.println(getName()+" your role is Software Engineer");
			}
		};
		Employee employee2 = new Employee("josh") {
			@Override
			void role() {
				System.out.println(getName()+" your role is Manager");
			}
		};
		employee1.role();
		employee2.role();
	}

}
