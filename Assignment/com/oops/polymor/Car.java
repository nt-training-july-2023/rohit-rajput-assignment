package com.oops.polymor;

public class Car extends Vehicle {

	@Override 
	public void run() {
		System.out.println("Car is running");
	}
	@Override
	public void speed() {
		System.out.println("Maximum speed of car is 200km/hr");
	}
	
	@Override 
	public void ac() {
		System.out.println("Car AC is on");
	}
	
}
