package com.oops.multipleinhe;

interface Vehicle {
	
	public void speed();
	public void sittingCapacity(); 

}
interface FourWheeler{
	
	public void speed();
	
}
public class Bus implements Vehicle , FourWheeler{
	
	@Override
	public void speed() {
		System.out.println("the average speed of Bus is 70-80 km/hr");
	}
	@Override
	public void sittingCapacity() {
		System.out.println("Sitting capacity of Bus is more than 40 passengers");
	}
	public static void main(String[] args) {
	    Bus bus = new Bus();
	    bus.speed();
	    bus.sittingCapacity();
	}
}
