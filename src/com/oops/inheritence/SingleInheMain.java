package com.oops.inheritence;
// Example of Single inheritence
class Sim {
	
	public void companyName() {
		System.out.println("Sim class companyName method");
	}
	
	public void rechargePlans() {
		System.out.println("Sim class rechargePlans method");
	}
	public void NumberStartsWith() {
		System.out.println("Sim class NumberStartsWith method");
	}
}
class JioSim extends Sim {
	
	@Override
	public void companyName() {
		System.out.println("Jio sim");
	} 
	@Override
	public void NumberStartsWith() {
		System.out.println("60..........");
	}
	public void offer() {
		System.out.println("We(Jio) gave our customer exciting offers");
	}

}
public class SingleInheMain{
	public static void main(String[] args) {
		JioSim sim = new JioSim();
		sim.companyName();
		sim.NumberStartsWith();
		sim.rechargePlans();
		sim.offer();
		
		
	}
}