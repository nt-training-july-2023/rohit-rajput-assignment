package com.oops.inheritence;
class SimClass {
	public void isDomestic() {
		System.out.println("Is this telecom service provider belongs to Indian origin ? :");
	}
	
	public void rechargePlans() {
		System.out.println("Recharge plans are same for every Telecom Company");
	}
	public void NumberStartsWith() {
		System.out.println("Sim class NumberStartsWith method");
	}
}
class JioSimClass  extends SimClass {
    	
 
	public void companyName() {
		System.out.println("Jio sim");
	} 
	@Override
	public void NumberStartsWith() {
		System.out.println("Jio number starts with 60+");
	}
	@Override
	public void isDomestic() {
		System.out.println("Is this telecom service provider belongs to Indian origin ? :YES");
	}

}
class AirtelSimClass extends SimClass{
	
	public void companyName() {
		System.out.println("Airtel Sim");
	} 
	@Override
	public void NumberStartsWith() {
		System.out.println("Airtel number starts with 80+");
	}
	@Override
	public void isDomestic() {
		System.out.println("Is this telecom service provider belongs to Indian origin ? :YES");
	}

	
}
public class HierarInnher {
	public static void main(String[] args) {
		JioSimClass sim1 = new JioSimClass();
		sim1.companyName();
		sim1.NumberStartsWith();
		sim1.rechargePlans();
		sim1.isDomestic();
		
		AirtelSimClass sim2 = new AirtelSimClass();
		sim2.companyName();
		sim2.NumberStartsWith();
		sim2.rechargePlans();
		sim2.isDomestic();
	}

}
