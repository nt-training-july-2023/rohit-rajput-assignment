package com.oops.polymor;

public class PolymorphismProgram {
    public static void main(String[] args) {
		Vehicle bikeVehicle = new Bike();
		bikeVehicle.speed();
		bikeVehicle.run();
		// calling the method of vehicle class
		bikeVehicle.ac();
		
		Vehicle carVehicle = new Car();
		carVehicle.speed();
		carVehicle.run();
		//calling the method of car class 
		carVehicle.ac();
		
	
		
	}
}
