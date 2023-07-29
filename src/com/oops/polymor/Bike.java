package com.oops.polymor;

public class Bike extends Vehicle {

	@Override
	public void run() {
		System.out.println("Bike is running");
	}
	
	@Override
	public void speed() {
		System.out.println("Maximum is of bike is 120km/hr");
	}
}
